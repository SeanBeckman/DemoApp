package com.example.demoapp.ui.contact

import com.example.demoapp.mocks.contact.ContactMocks.Companion.defaultContact
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ContactListItemViewModelTest {

    private lateinit var subject: ContactItemViewModel

    @Before
    fun init() {
        subject = ContactItemViewModel(defaultContact)
    }

    @Test
    fun `when initialised then stream values are populated`() {
        assertEquals(defaultContact.name, subject.name)
        assertEquals(defaultContact.email, subject.email)
    }
}