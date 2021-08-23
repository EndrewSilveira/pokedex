package com.example.pokedex2.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Chain (
    @SerializedName("evolution_details")
    val evolutionDetails: List<EvolutionDetails>,
    @SerializedName("evolves_to")
    val evolvesTo: List<Chain>,
    val species: PokemonSpecies?
): Parcelable
