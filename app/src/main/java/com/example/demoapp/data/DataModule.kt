package com.example.demoapp.data

import com.example.demoapp.data.contact.ContactRepository
import com.example.demoapp.data.contact.GetContactsService
import com.example.demoapp.data.contact.GetContactsService.Companion.CONTACTS_ENDPOINT
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    factory<GetContactsService> {
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(CONTACTS_ENDPOINT)
            .build()
            .create(GetContactsService::class.java)
    }

    factory { ContactRepository(get(), get(named("DataThreadScheduler")), get(named("UiThreadScheduler"))) }
    single(named("DataThreadScheduler")) { Schedulers.io() }
    single(named("UiThreadScheduler")) { AndroidSchedulers.mainThread() }
}