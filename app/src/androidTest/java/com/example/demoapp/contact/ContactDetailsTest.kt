package com.example.demoapp.contact

import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.demoapp.R
import com.example.demoapp.contact.ContactMocks.Companion.defaultContact
import com.example.demoapp.ui.contact.ContactFragment
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ContactDetailsTest {

    @Before
    fun init() {
        val fragmentArgs = Bundle().apply {
            putParcelable("contact", defaultContact)
        }

        launchFragmentInContainer<ContactFragment>(fragmentArgs, R.style.AppTheme)
    }

    @Test fun whenViewLoadsWithAContact_thenAllFieldsShouldBePopulated() {
        onView(
            allOf(
                instanceOf(TextView::class.java),
                withParent(withId(R.id.toolbar))
            )
        ).check(matches(withText("Enron Muscovite")))
        onView(withId(R.id.username)).check(matches(withText("Enron")))
        onView(withId(R.id.email)).check(matches(withText("enron@teesla.com")))
        onView(withId(R.id.website)).check(matches(withText("teesla.com")))
        onView(withId(R.id.phone_number)).check(matches(withText("0000000000")))
        onView(withId(R.id.street)).check(matches(withText("Wherever my plane decides to land")))
        onView(withId(R.id.suite)).check(matches(withText("Room 251b")))
        onView(withId(R.id.city)).check(matches(withText("Lost Angeles")))
        onView(withId(R.id.zipcode)).check(matches(withText("90210")))
        onView(withId(R.id.latlng)).check(matches(withText("22.0, 20.0")))
        onView(withId(R.id.company_name)).check(matches(withText("Teesla")))
        onView(withId(R.id.company_catch_phrase)).check(matches(withText("We make electric chair lifts!")))
        onView(withId(R.id.company_bs)).check(matches(withText("Driving the future, on off piste at a time")))
    }
}