package com.example.demoapp.data.contact

import com.example.demoapp.domain.UseCaseError
import com.example.demoapp.domain.UseCaseResult
import com.example.demoapp.domain.UseCaseSuccess
import com.example.demoapp.domain.contact.model.Contact
import io.reactivex.Scheduler
import io.reactivex.Single

open class ContactRepository (
    private val getContactsService: GetContactsService,
    private val dataThreadScheduler: Scheduler,
    private val UiThreadScheduler: Scheduler
) {

    open fun getContacts(): Single<UseCaseResult<List<Contact>>> =
        getContactsService
            .contacts
            .map { UseCaseSuccess(it) as UseCaseResult<List<Contact>> } // have to implicitly upcast :(
            .observeOn(UiThreadScheduler)
            .subscribeOn(dataThreadScheduler)
            .onErrorReturn { UseCaseError(it.localizedMessage ?: it.toString()) }
}