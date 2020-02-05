package com.example.intentsandactivities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Person(
    var perFirstName: String,
    var perLastName: String,
    var perAge: String,
    var perGender: String,
    var perHomeTown: String) : Parcelable
