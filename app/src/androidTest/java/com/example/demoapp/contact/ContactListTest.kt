package com.example.demoapp.contact

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.demoapp.MainActivity
import com.example.demoapp.R
import com.example.demoapp.contact.ContactMocks.Companion.serviceMockForDefaultContact
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import java.net.HttpURLConnection.HTTP_OK


@RunWith(AndroidJUnit4::class)
class ContactListTest {

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    private val mockWebServer: MockWebServer = MockWebServer()

    @Before
    fun start() {
        loadKoinModules(instrumentationModule)
        activityTestRule.launchActivity(Intent())

        mockWebServer.start(8080)
        val mockResponse = MockResponse()
            .setResponseCode(HTTP_OK)
            .setBody(serviceMockForDefaultContact)
        mockWebServer.enqueue(mockResponse)
    }

    @After
    fun shutDown() {
        mockWebServer.shutdown()
    }

    @Test fun whenViewLoadsWithContacts_thenListShouldBeShown() {
        onView(withId(R.id.contact_list)).check(matches(isDisplayed()))
        // Bashed my head against mock web server for half a day so left these UI test unfortunately broken and unfinished
    }
}