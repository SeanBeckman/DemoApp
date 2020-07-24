package com.example.demoapp.contact

import com.example.demoapp.data.contact.GetContactsService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val instrumentationModule = module {
    factory <GetContactsService>(override = true) {
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://localhost:8080/")
            .build()
            .create(GetContactsService::class.java)
    }
}