package com.example.pokedex2.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EvolutionTrigger (
    val name: String?,
    val url: String?,
): Parcelable
