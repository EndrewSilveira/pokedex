package com.example.pokedex2.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ability (
    val ability: PokemonAbility
): Parcelable
