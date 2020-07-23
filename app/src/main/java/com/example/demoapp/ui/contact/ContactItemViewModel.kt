package com.example.demoapp.ui.contact

import androidx.lifecycle.ViewModel
import com.example.demoapp.BR
import com.example.demoapp.R
import com.example.demoapp.domain.contact.model.Contact
import com.fraggjkee.recycleradapter.RecyclerItem

class ContactItemViewModel(val data: Contact): ViewModel() {
    lateinit var itemClicked: (contact: Contact) -> Unit

    fun onItemClick() {
        itemClicked(data)
    }
}

fun Contact.createViewModel(itemClicked: (Contact) -> Unit): ContactItemViewModel = ContactItemViewModel(this).apply { this.itemClicked = itemClicked }
fun ContactItemViewModel.toRecyclerItem(): RecyclerItem = RecyclerItem(
    data = this,
    layoutId = R.layout.contact_item,
    variableId = BR.viewModel
)