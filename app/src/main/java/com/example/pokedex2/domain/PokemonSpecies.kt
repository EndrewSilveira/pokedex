package com.example.pokedex2.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class PokemonSpecies (
    val id: Int,
    val name: String,
    val url: String?,
    @SerializedName("base_happiness")
    val baseHappiness: Int,
    @SerializedName("capture_rate")
    val captureRate: Int,
    @SerializedName("egg_groups")
    val eggGroups: List<EggGroup>,
    @SerializedName("flavor_text_entries")
    val flavorTextEntries:  List<TextEntries>,
    @SerializedName("pokedex_numbers")
    val pokedexNumbers: List<PokedexNumbers>,
    @SerializedName("evolution_chain")
    val evolutionChain: EvolutionChainUrl,
    @SerializedName("evolves_from_species")
    val evolvesFromSpecies: PokemonSpecies?
): Parcelable
