package com.example.demoapp.ui.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.demoapp.domain.UseCaseError
import com.example.demoapp.domain.UseCaseResult
import com.example.demoapp.domain.UseCaseSuccess
import com.example.demoapp.domain.contact.model.Contact
import com.example.demoapp.domain.contact.usecase.GetContacts
import com.example.demoapp.ui.BaseViewModel
import com.example.demoapp.ui.utils.subscribeWithErrorHandling
import io.reactivex.disposables.CompositeDisposable

class ContactListViewModel (private val getContacts: GetContacts) : BaseViewModel() {

    private val _isLoading = MutableLiveData<Boolean>().apply { value = true }
    val isLoading: LiveData<Boolean> = _isLoading

    private val _hasError = MutableLiveData<Boolean>().apply { value = false }
    val hasError: LiveData<Boolean> = _hasError

    private val _contacts = MutableLiveData<List<Contact>>()
    val contacts: LiveData<List<Contact>?> = _contacts
    val hasData: LiveData<Boolean> = Transformations.map(contacts) {
        it?.isEmpty()
    }

    private val compositeDisposable = CompositeDisposable()

    init {
        load()
    }

    override fun clear() {
        compositeDisposable.clear()
    }

    private fun load() {
        val disposable = getContacts
            .execute()
            .subscribeWithErrorHandling(this::processResult, this::processError)
        compositeDisposable.add(disposable)

        _isLoading.value = true
        _hasError.value = false
    }

    private fun processResult(result: UseCaseResult<List<Contact>>) {
        when (result) {
            is UseCaseSuccess -> processSuccess(result.value)
            is UseCaseError -> processError()
        }
    }

    private fun processSuccess(contacts: List<Contact>) {
        _contacts.value = contacts
        _isLoading.value = true
        _hasError.value = false
    }

    private fun processError() {
        _contacts.value = null
        _isLoading.value = false
        _hasError.value = true
    }
}