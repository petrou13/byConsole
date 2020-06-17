package com.example.picasso

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemOfList (
    val imageSrc: String
) : Parcelable