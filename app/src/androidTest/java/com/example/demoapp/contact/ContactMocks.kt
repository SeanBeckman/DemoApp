package com.example.demoapp.contact

import com.example.demoapp.domain.contact.model.Address
import com.example.demoapp.domain.contact.model.Company
import com.example.demoapp.domain.contact.model.Contact
import com.example.demoapp.domain.contact.model.LatLng

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


         val serviceMockForDefaultContact = """
             [
               {
                 "id": 123,
                "name": "Enron Muscovite",
                "username": "Enron",
                "email": "enron@teesla.com",
                "address": {
                  "street": "Wherever my plane decides to land",
                  "suite": "Room 251b",
                  "city": "Lost Angeles",
                  "zipcode": "90210",
                  "geo": {
                    "lat": "22.0",
                    "lng": "20.0"
                  }
                },
                "phone": "0000000000",
                "website": "teesla.com",
                "company": {
                  "name": "Teesla",
                  "catchPhrase": "We make electric chair lifts!",
                  "bs": "Driving the future, on off piste at a tim"
                 }
               }
             ]
         """.trimIndent()
    }
}