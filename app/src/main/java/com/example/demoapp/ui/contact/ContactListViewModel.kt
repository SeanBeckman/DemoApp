package com.example.demoapp.ui.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.demoapp.domain.contact.model.Contact
import com.example.demoapp.domain.contact.usecase.GetContacts
import com.example.demoapp.ui.BaseViewModel
import com.fraggjkee.recycleradapter.RecyclerItem

class ContactListViewModel (
    private val getContacts: GetContacts
) : BaseViewModel<List<Contact>>() {

    private val _recyclerItems = MutableLiveData<List<RecyclerItem>>()
    val recyclerItems: LiveData<List<RecyclerItem>> = _recyclerItems

    private val _itemSelection = MutableLiveData<Contact>()
    val itemSelection: LiveData<Contact> = _itemSelection

    init {
        load()
    }

    private fun load() {
        processUseCase(getContacts)
    }

    override fun processSuccess(result: List<Contact>) {
        _recyclerItems.value = result
            .map { contact -> contact.createViewModel { this.goToDetail(contact) } }
            .map { it.toRecyclerItem() }
    }

    override fun processError() {
        // Nothing to do
    }

    private fun goToDetail(contact: Contact) {
        _itemSelection.value = contact
        _itemSelection.value = null
    }
}