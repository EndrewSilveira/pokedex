package com.example.pokedex2.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Moves (
    val id: Int,
    val accuracy: Int,
    val name: String,
    val power: Int,
    val pp: Int,
):Parcelable
