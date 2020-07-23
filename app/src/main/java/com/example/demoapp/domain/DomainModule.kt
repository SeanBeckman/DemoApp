package com.example.demoapp.domain

import com.example.demoapp.domain.contact.usecase.GetContacts
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.qualifier.named
import org.koin.dsl.module

val domainModule = module {
    factory { GetContacts(get(), get(named("DataThreadScheduler")), get(named("UiThreadScheduler"))) }
    single(named("DataThreadScheduler")) { Schedulers.newThread() }
    single(named("UiThreadScheduler")) { AndroidSchedulers.mainThread() }
}