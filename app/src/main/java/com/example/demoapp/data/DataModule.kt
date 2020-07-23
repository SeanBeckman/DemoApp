package com.example.demoapp.data

import com.example.demoapp.data.contact.ContactRepository
import com.example.demoapp.data.contact.GetContactsService
import com.example.demoapp.data.contact.GetContactsService.Companion.CONTACTS_ENDPOINT
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single<GetContactsService> {
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(CONTACTS_ENDPOINT)
            .build()
            .create(GetContactsService::class.java)
    }

    factory { ContactRepository(get()) }
}