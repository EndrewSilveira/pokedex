package com.example.pokedex2.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EvolutionDetails (
    @SerializedName("gender")
    val gender: Int?,
    @SerializedName("held_item")
    val heldItem: String?,
    @SerializedName("item")
    val item: String?,
    @SerializedName("location")
    val location: String?,
    @SerializedName("needs_overworld_rain")
    val needsOverWorldRain: String?,
    @SerializedName("min_level")
    val minLevel: Int?,
    @SerializedName("min_happiness")
    val minHappiness: Int?,
    @SerializedName("min_beauty")
    val minBeauty: Int?,
    @SerializedName("min_affection")
    val minAffection: Int?,
    @SerializedName("time_of_day")
    val timeOfDay: String?,
    @SerializedName("trigger")
    val trigger: EvolutionTrigger?,
): Parcelable
