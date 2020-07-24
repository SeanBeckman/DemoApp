package com.example.demoapp.ui.contact

import com.example.demoapp.domain.contact.model.Contact
import com.example.demoapp.ui.BaseViewModel

class ContactViewModel(contact: Contact) : BaseViewModel<Contact>() {

    val name = contact.name
    val userName = contact.username
    val email = contact.email
    val addressStreet = contact.address.street
    val addressSuite = contact.address.suite
    val addressCity = contact.address.city
    val addressZipCode = contact.address.zipcode
    val addressLatLng = "${contact.address.geo.latitude}, ${contact.address.geo.longitude}"
    val phoneNumber = contact.phone
    val website = contact.website
    val companyName = contact.company.name
    val companyCatchphrase = contact.company.catchPhrase
    val companyBs = contact.company.bs

    override fun processSuccess(result: Contact) {
        // Not used, we don't load data here
    }

    override fun processError() {
        // Not used
    }
}