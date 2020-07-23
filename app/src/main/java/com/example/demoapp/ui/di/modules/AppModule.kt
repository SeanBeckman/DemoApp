package com.example.demoapp.ui.di.modules

import com.example.demoapp.ui.contact.ContactListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        ContactListViewModel(get())
    }
}
