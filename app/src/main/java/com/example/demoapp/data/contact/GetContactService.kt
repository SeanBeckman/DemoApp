package com.example.demoapp.data.contact

import com.example.demoapp.domain.contact.model.Contact
import io.reactivex.Single
import retrofit2.http.GET

interface GetContactsService {
    @get:GET(value = "users")
    val contacts: Single<List<Contact>>

    companion object {
        const val CONTACTS_ENDPOINT = "http://jsonplaceholder.typicode.com/"
    }
}