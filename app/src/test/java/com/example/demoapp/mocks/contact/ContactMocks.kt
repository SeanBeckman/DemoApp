package com.example.demoapp.mocks.contact

import com.example.demoapp.TestException
import com.example.demoapp.domain.UseCaseError
import com.example.demoapp.domain.UseCaseResult
import com.example.demoapp.domain.UseCaseSuccess
import com.example.demoapp.domain.contact.model.Address
import com.example.demoapp.domain.contact.model.Company
import com.example.demoapp.domain.contact.model.Contact
import com.example.demoapp.domain.contact.model.LatLng
import io.reactivex.Single

class ContactMocks {
    companion object {
        val defaultContact = Contact(
            "some guid",
            "Enron Muscovite",
            "Enron",
            "enron@teesla.com",
            Address(
                "Wherever my plane decides to land",
                "Room 251b",
                "Lost Angeles",
                "90210",
                LatLng(
                    22.0,
                    20.0
                )
            ),
            "0000000000",
            "teesla.com",
            Company(
                "Teesla",
                "We make electric chair lifts!",
                "Driving the future, on off piste at a time"
            )
        )

        val streamForOneContact: Single<UseCaseResult<List<Contact>>> =
            Single.just(UseCaseSuccess(listOf(defaultContact)))

        val streamWithError: Single<UseCaseResult<List<Contact>>> =
            Single.just(UseCaseError("Some error"))

        val streamWithException: Single<UseCaseResult<List<Contact>>> =
            Single.error(TestException())
    }
}