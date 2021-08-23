package com.example.pokedex2.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class PokedexNumbers (
    val pokedexNumbersResult: EntryPokedexNumbers
):Parcelable
