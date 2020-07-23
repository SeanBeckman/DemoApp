package com.example.demoapp.domain.contact.usecase

import com.example.demoapp.data.contact.ContactRepository
import com.example.demoapp.domain.BaseGetUseCase
import com.example.demoapp.domain.UseCaseResult
import com.example.demoapp.domain.contact.model.Contact
import io.reactivex.Single

class GetContacts (
    private val contactRepository: ContactRepository
): BaseGetUseCase<List<Contact>>() {
    override fun execute(): Single<UseCaseResult<List<Contact>>> {
        return contactRepository.getContacts()
    }
}