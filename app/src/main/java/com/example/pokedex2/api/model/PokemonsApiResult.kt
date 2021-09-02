package com.example.pokedex2.api.model

import android.os.Parcelable
import com.example.pokedex2.domain.*
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class PokemonsApiResult(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResult>
)
data class PokemonResult (
    val name: String,
    val url: String,
)

data class PokemonApiResult(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val abilities: List<Ability>?,
    val moves: List<PokemonMove>?,
    val species: PokemonSpecies,
    val types: List<PokemonTypeSlot>,
    val stats: List<PokemonStats>,
    val sprites: PokemonSprites?
)

data class PokemonSpeciesResult(
    @SerializedName("base_happiness")
    val baseHappiness: Int,
    @SerializedName("capture_rate")
    val captureRate: Int,
    @SerializedName("egg_groups")
    val eggGroups: List<EggGroup>,
    @SerializedName("flavor_text_entries")
    val flavorTextEntries: List<TextEntries>,
)

data class MovesApiResult (
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Moves>
)

data class MovesResult (
    val name: String,
    val url: String,
)

data class PokemonTypeSlot (
    val slot: Int,
    val type: PokemonType
)