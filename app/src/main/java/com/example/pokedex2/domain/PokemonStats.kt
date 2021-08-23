package com.example.pokedex2.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonStats (
    @SerializedName("base_stat") val baseStat: Int?,
    val effort: Int?,
    val stat: Stat?
): Parcelable