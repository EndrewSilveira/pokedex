package com.example.pokedex2.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DamageRelation (
    @SerializedName("double_damage_from")
    val doubleDamageFrom: List<PokemonType>
):Parcelable
