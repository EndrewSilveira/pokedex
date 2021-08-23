package com.example.pokedex2.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EntryPokedexNumbers (
    @SerializedName("entry_number")
    val entryNumber: Int?,
): Parcelable
