package com.example.demoapp.domain

import com.example.demoapp.domain.contact.usecase.GetContacts
import org.koin.dsl.module

val domainModule = module {
    factory { GetContacts(get()) }
}