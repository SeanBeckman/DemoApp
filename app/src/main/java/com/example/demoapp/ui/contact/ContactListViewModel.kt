package com.example.demoapp.ui.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.example.demoapp.domain.UseCaseError
import com.example.demoapp.domain.UseCaseResult
import com.example.demoapp.domain.UseCaseSuccess
import com.example.demoapp.domain.contact.model.Contact
import com.example.demoapp.domain.contact.usecase.GetContacts
import com.example.demoapp.ui.BaseViewModel
import com.example.demoapp.ui.utils.subscribeWithErrorHandling
import com.fraggjkee.recycleradapter.RecyclerItem
import io.reactivex.disposables.CompositeDisposable

class ContactListViewModel (private val getContacts: GetContacts) : BaseViewModel() {

    private val _isLoading = MutableLiveData<Boolean>().apply { value = true }
    val isLoading: LiveData<Boolean> = _isLoading

    private val _hasError = MutableLiveData<Boolean>().apply { value = false }
    val hasError: LiveData<Boolean> = _hasError

    private val _recyclerItems = MutableLiveData<List<RecyclerItem>>()
    val recyclerItems: LiveData<List<RecyclerItem>> = _recyclerItems
    val hasData: LiveData<Boolean> = recyclerItems.map { it.isNotEmpty() }

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
        _recyclerItems.value = contacts
            .map { contact -> contact.createViewModel { this.goToDetail(contact) } }
            .map { it.toRecyclerItem() }
        _isLoading.value = false
        _hasError.value = false
    }

    private fun processError() {
        _recyclerItems.value = null
        _isLoading.value = false
        _hasError.value = true
    }

    private fun goToDetail(contact: Contact) {
        // TODO: go to next page
    }
}