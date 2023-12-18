package com.dicoding.phonespecs

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Phone(
    var name: String,
    var description: String,
    var descriptionTwo: String,
    var photo: Int
) : Parcelable
