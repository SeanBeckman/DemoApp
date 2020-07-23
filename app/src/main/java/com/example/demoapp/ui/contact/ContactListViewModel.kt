package com.example.demoapp.ui.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactListViewModel : ViewModel() {

    val isLoading: LiveData<Boolean> = MutableLiveData<Boolean>().apply { value = false }
    val hasError: LiveData<Boolean> = MutableLiveData<Boolean>().apply { value = false }
    val contact: LiveData<Unit> = MutableLiveData<Unit>()
}