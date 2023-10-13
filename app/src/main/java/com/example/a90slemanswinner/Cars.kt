package com.example.a90slemanswinner

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cars(
    val image: Int,
    val name: String,
    val year: String,
    val content:String) : Parcelable


