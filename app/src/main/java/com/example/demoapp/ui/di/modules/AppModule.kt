package com.example.demoapp.ui.di.modules

import com.example.demoapp.domain.contact.model.Contact
import com.example.demoapp.ui.contact.ContactListViewModel
import com.example.demoapp.ui.contact.ContactViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        ContactListViewModel(get())
    }

    viewModel { (contact: Contact) ->
        ContactViewModel(contact)
    }
}
