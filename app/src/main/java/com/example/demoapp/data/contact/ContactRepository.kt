package com.example.demoapp.data.contact

import com.example.demoapp.domain.UseCaseError
import com.example.demoapp.domain.UseCaseResult
import com.example.demoapp.domain.UseCaseSuccess
import com.example.demoapp.domain.contact.model.Contact
import io.reactivex.Single

class ContactRepository (private val getContactsService: GetContactsService) {

    fun getContacts(): Single<UseCaseResult<List<Contact>>> =
        getContactsService
            .contacts
            .map { UseCaseSuccess(it) as UseCaseResult<List<Contact>> } // have to implicitly upcast :(
            .onErrorReturn { UseCaseError(it) }
}