package com.example.demoapp.domain.contact.usecase

import com.example.demoapp.TestException
import com.example.demoapp.data.contact.ContactRepository
import com.example.demoapp.domain.UseCaseSuccess
import com.example.demoapp.mocks.contact.ContactMocks.Companion.defaultContact
import com.example.demoapp.mocks.contact.ContactMocks.Companion.streamForOneContact
import com.example.demoapp.mocks.contact.ContactMocks.Companion.streamWithException
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.schedulers.Schedulers
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GetContactsUseCaseTests {

    private lateinit var subject: GetContacts

    @Mock
    private lateinit var repositoryMock: ContactRepository

    private val testScheduler = Schedulers.trampoline()

    @Before
    fun init() {
        MockitoAnnotations.openMocks(this)

        subject = GetContacts(
            repositoryMock,
            testScheduler,
            testScheduler
        )
    }

    @Test
    fun `given the repository returns the list when use case executes then pass on success`() {
        whenever(repositoryMock.getContacts())
            .thenReturn(streamForOneContact)

        val testObserver = subject
            .execute()
            .test()

        testObserver.assertValue {
            return@assertValue if (it is UseCaseSuccess) {
                assertEquals(defaultContact.name, it.value[0].name)
                true
            } else false
        }
            .assertComplete()
    }

    @Test
    fun `given the repository stream emits an error when use case executes then pass on an error result`() {
        whenever(repositoryMock.getContacts())
            .thenReturn(streamWithException)

        val testObserver = subject
            .execute()
            .test()

        testObserver.assertError {
            it is TestException
        }
            .assertNotComplete()
    }
}