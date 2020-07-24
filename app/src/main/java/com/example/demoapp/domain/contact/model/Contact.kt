package com.example.demoapp.domain.contact.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact(
    val id: String,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
): Parcelable

@Parcelize
data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipCode: String,
    val geo: LatLng
): Parcelable

@Parcelize
data class LatLng(
    val latitude: Double,
    val longitude: Double
): Parcelable

@Parcelize
data class Company(
    val name: String,
    val catchphrase: String,
    val bs: String
): Parcelable