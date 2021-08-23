package com.example.pokedex2.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon (
    @SerializedName("id")
    val number: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val stats: List<PokemonStats>?,
    val abilities: List<Ability>?,
    val moves: List<Move>?,
    val species: PokemonSpecies,
    val types: List<PokemonType>,
    val sprites: PokemonSprites?
): Parcelable {
    val formattedName = name.capitalize()
    val formattedNumber = number.toString().padStart(3, '0')
    val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$formattedNumber.png"
//    val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$number.png"
}