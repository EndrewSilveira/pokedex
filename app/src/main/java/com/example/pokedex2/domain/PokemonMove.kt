package com.example.pokedex2.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonMove (
    val move: Move,
    @SerializedName("version_group_details")
    val versionGroupDetails: List<VersionGroupDetails>
): Parcelable
