package com.example.pokedex2.screen.home

import android.content.Context
import android.os.Build
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.example.pokedex2.R
import com.example.pokedex2.domain.Constant
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.layout_pokedex_item.view.*
import java.security.AccessController.getContext

class PokemonTypeStyle(textView: AppCompatTextView?, cardView: MaterialCardView) {

    private val txtType1 = textView
    private val cvPokemonCard: MaterialCardView = cardView

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun styleTypeSlotOne(itemView: View) {
        when(txtType1?.text){
            Constant.GRASS_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.grass_bd))
            }
            Constant.FIRE_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.fire_bd))
            }
            Constant.WATER_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.water_bd))
            }
            Constant.POISON_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.poison_bd))
            }
            Constant.BUG_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.bug_bd))
            }
            Constant.NORMAL_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.normal_bd))
            }
            Constant.ELECTRIC_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.electric_bd))
            }
            Constant.FAIRY_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.fairy_bd))
            }
            Constant.FIGHTING_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.fighting_bd))
            }
            Constant.PSYCHIC_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.psychic_bd))
            }
            Constant.ROCK_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.rock_bd))
            }
            Constant.STEEL_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.steel_bd))
            }
            Constant.GHOST_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.ghost_bd))
            }
            Constant.ICE_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.ice_bd))
            }
            Constant.FLYING_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.flying_bd))
            }
            Constant.GROUND_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.ground_bd))
            }
            Constant.DRAGON_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.dragon_bd))
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun styleWeakness(itemView: View, type: String, icon: AppCompatImageView) {
        when(type){
            Constant.GRASS_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.grass_bd))
                val typeIcon = ContextCompat.getDrawable(itemView.context, R.drawable.ic_grass)
                typeIcon?.apply {
                    setTint(ContextCompat.getColor(itemView.context, R.color.white))
                }
                icon.background = typeIcon
            }
            Constant.FIRE_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.fire_bd))
                val typeIcon = ContextCompat.getDrawable(itemView.context, R.drawable.ic_fire)
                typeIcon?.apply {
                    setTint(ContextCompat.getColor(itemView.context, R.color.white))
                }
                icon.background = typeIcon
            }
            Constant.WATER_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.water_bd))
                val typeIcon = ContextCompat.getDrawable(itemView.context, R.drawable.ic_water)
                typeIcon?.apply {
                    setTint(ContextCompat.getColor(itemView.context, R.color.white))
                }
                icon.background = typeIcon
            }
            Constant.POISON_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.poison_bd))
                val typeIcon = ContextCompat.getDrawable(itemView.context, R.drawable.ic_venom)
                typeIcon?.apply {
                    setTint(ContextCompat.getColor(itemView.context, R.color.white))
                }
                icon.background = typeIcon
            }
            Constant.BUG_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.bug_bd))
                icon.setBackgroundResource(R.drawable.ic_bug)
            }
            Constant.NORMAL_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.normal_bd))
                icon.setBackgroundResource(R.drawable.ic_normal)
            }
            Constant.ELECTRIC_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.electric_bd))
                val typeIcon = ContextCompat.getDrawable(itemView.context, R.drawable.ic_eletric)
                typeIcon?.apply {
                    setTint(ContextCompat.getColor(itemView.context, R.color.white))
                }
                icon.background = typeIcon
            }
            Constant.FAIRY_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.fairy_bd))
                val typeIcon = ContextCompat.getDrawable(itemView.context, R.drawable.ic_fairy)
                typeIcon?.apply {
                    setTint(ContextCompat.getColor(itemView.context, R.color.white))
                }
                icon.background = typeIcon
            }
            Constant.FIGHTING_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.fighting_bd))
                val typeIcon = ContextCompat.getDrawable(itemView.context, R.drawable.ic_fight)
                typeIcon?.apply {
                    setTint(ContextCompat.getColor(itemView.context, R.color.white))
                }
                icon.background = typeIcon
            }
            Constant.PSYCHIC_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.psychic_bd))
                val typeIcon = ContextCompat.getDrawable(itemView.context, R.drawable.ic_psychic)
                typeIcon?.apply {
                    setTint(ContextCompat.getColor(itemView.context, R.color.white))
                }
                icon.background = typeIcon
            }
            Constant.ROCK_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.rock_bd))
                val typeIcon = ContextCompat.getDrawable(itemView.context, R.drawable.ic_rock)
                typeIcon?.apply {
                    setTint(ContextCompat.getColor(itemView.context, R.color.white))
                }
                icon.background = typeIcon
            }
            Constant.STEEL_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.steel_bd))
                val typeIcon = ContextCompat.getDrawable(itemView.context, R.drawable.ic_steel)
                typeIcon?.apply {
                    setTint(ContextCompat.getColor(itemView.context, R.color.white))
                }
                icon.background = typeIcon
            }
            Constant.GHOST_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.ghost_bd))
                val typeIcon = ContextCompat.getDrawable(itemView.context, R.drawable.ic_ghost)
                typeIcon?.apply {
                    setTint(ContextCompat.getColor(itemView.context, R.color.white))
                }
                icon.background = typeIcon
            }
            Constant.ICE_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.ice_bd))
                val typeIcon = ContextCompat.getDrawable(itemView.context, R.drawable.ic_ice)
                typeIcon?.apply {
                    setTint(ContextCompat.getColor(itemView.context, R.color.white))
                }
                icon.background = typeIcon
            }
            Constant.FLYING_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.flying_bd))
                val typeIcon = ContextCompat.getDrawable(itemView.context, R.drawable.ic_flying)
                typeIcon?.apply {
                    setTint(ContextCompat.getColor(itemView.context, R.color.white))
                }
                icon.background = typeIcon
            }
            Constant.GROUND_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.ground_bd))
                val typeIcon = ContextCompat.getDrawable(itemView.context, R.drawable.ic_ground)
                typeIcon?.apply {
                    setTint(ContextCompat.getColor(itemView.context, R.color.white))
                }
                icon.background = typeIcon
            }
            Constant.DRAGON_TYPE -> {
                cvPokemonCard.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.dragon_bd))
                val typeIcon = ContextCompat.getDrawable(itemView.context, R.drawable.ic_dragon)
                typeIcon?.apply {
                    setTint(ContextCompat.getColor(itemView.context, R.color.white))
                }
                icon.background = typeIcon
            }
        }
    }
}