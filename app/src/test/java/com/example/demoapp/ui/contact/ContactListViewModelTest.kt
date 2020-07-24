package com.example.demoapp.ui.contact

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.demoapp.domain.contact.usecase.GetContacts
import com.example.demoapp.mocks.contact.ContactMocks.Companion.defaultContact
import com.example.demoapp.mocks.contact.ContactMocks.Companion.streamForOneContact
import com.example.demoapp.mocks.contact.ContactMocks.Companion.streamWithError
import com.example.demoapp.ui.ViewState
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ContactListViewModelTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var subject: ContactListViewModel

    @Mock
    private lateinit var useCaseMock: GetContacts

    @Before
    fun init() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `given user has contacts when view models initialises then list is populated`() {
        whenever(useCaseMock.execute()).thenReturn(streamForOneContact)

        subject = ContactListViewModel(useCaseMock)

        assertEquals(ViewState.HasData, subject.state.value)
        assertTrue(subject.recyclerItems.value?.isNotEmpty() == true)
        assertEquals(defaultContact.name, (subject.recyclerItems.value?.get(0)?.data as? ContactItemViewModel)?.name)
    }

    @Test
    fun `given user contacts fetch errors when view model initialises then error is shown`() {
        whenever(useCaseMock.execute()).thenReturn(streamWithError)

        subject = ContactListViewModel(useCaseMock)

        assertEquals(ViewState.HasError, subject.state.value)
        assertTrue(subject.recyclerItems.value?.isNotEmpty() != true)
    }
}