package com.example.pokedex2.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Move (
    val name: String,
    @SerializedName("version_group_details") val versionGroupDetails: List<PokemonMoveDetail>
): Parcelable
