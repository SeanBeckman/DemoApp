package com.example.demoapp.ui.contact

import androidx.lifecycle.ViewModel
import com.example.demoapp.BR
import com.example.demoapp.R
import com.example.demoapp.domain.contact.model.Contact
import com.fraggjkee.recycleradapter.RecyclerItem

class ContactItemViewModel(private val data: Contact): ViewModel() {

    val name = data.name
    val email = data.email

    // Not really a great way to handle click events but it will do for now
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