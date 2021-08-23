package com.example.pokedex2.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Stat (
    val name: String?,
    val url: String?
): Parcelable
