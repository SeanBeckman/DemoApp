package com.example.demoapp.domain.contact.model

data class Contact(
    val id: String,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)

data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipCode: String,
    val geo: LatLng
)

data class LatLng(
    val latitude: Double,
    val longitude: Double
)

data class Company(
    val name: String,
    val catchphrase: String,
    val bs: String
)