package com.example.pokedex2.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EvolutionChain (
    @SerializedName("baby_trigger_item")
    val babyTriggerItem: String?,
    val chain: Chain,
    val id: Int?,
    val number: Int?
):Parcelable {
    val pokemonNumber = number.toString().padStart(3, '0')
    val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$pokemonNumber.png"
}
