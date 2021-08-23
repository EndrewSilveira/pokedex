package com.example.pokedex2.screen.detail

import android.content.Context
import android.os.Build
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import com.example.pokedex2.R
import com.example.pokedex2.domain.Constant
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.layout_pokedex_item.view.*

class PokemonTypeDetailStyle(private val txtType1: AppCompatTextView, private val clDetailBack: View) {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun styleTypeSlotOne(context: Context) {
        when(txtType1.text){
            Constant.GRASS_TYPE -> {
                clDetailBack.setBackgroundColor(ContextCompat.getColor(context, R.color.grass_bd))
            }
            Constant.FIRE_TYPE -> {
                clDetailBack.setBackgroundColor(ContextCompat.getColor(context, R.color.fire_bd))
            }
            Constant.WATER_TYPE -> {
                clDetailBack.setBackgroundColor(ContextCompat.getColor(context, R.color.water_bd))
            }
            Constant.POISON_TYPE -> {
                clDetailBack.setBackgroundColor(ContextCompat.getColor(context, R.color.poison_bd))
            }
            Constant.BUG_TYPE -> {
                clDetailBack.setBackgroundColor(ContextCompat.getColor(context, R.color.bug_bd))
            }
            Constant.NORMAL_TYPE -> {
                clDetailBack.setBackgroundColor(ContextCompat.getColor(context, R.color.normal_bd))
            }
            Constant.ELECTRIC_TYPE -> {
                clDetailBack.setBackgroundColor(ContextCompat.getColor(context, R.color.electric_bd))
            }
            Constant.FAIRY_TYPE -> {
                clDetailBack.setBackgroundColor(ContextCompat.getColor(context, R.color.fairy_bd))
            }
            Constant.FIGHTING_TYPE -> {
                clDetailBack.setBackgroundColor(ContextCompat.getColor(context, R.color.fighting_bd))
            }
            Constant.PSYCHIC_TYPE -> {
                clDetailBack.setBackgroundColor(ContextCompat.getColor(context, R.color.psychic_bd))
            }
            Constant.ROCK_TYPE -> {
                clDetailBack.setBackgroundColor(ContextCompat.getColor(context, R.color.rock_bd))
            }
            Constant.STEEL_TYPE -> {
                clDetailBack.setBackgroundColor(ContextCompat.getColor(context, R.color.steel_bd))
            }
            Constant.GHOST_TYPE -> {
                clDetailBack.setBackgroundColor(ContextCompat.getColor(context, R.color.ghost_bd))
            }
            Constant.ICE_TYPE -> {
                clDetailBack.setBackgroundColor(ContextCompat.getColor(context, R.color.ice_bd))
            }
            Constant.FLYING_TYPE -> {
                clDetailBack.setBackgroundColor(ContextCompat.getColor(context, R.color.flying_bd))
            }
            Constant.GROUND_TYPE -> {
                clDetailBack.setBackgroundColor(ContextCompat.getColor(context, R.color.ground_bd))
            }
            Constant.DRAGON_TYPE -> {
                clDetailBack.setBackgroundColor(ContextCompat.getColor(context, R.color.dragon_bd))
            }
        }
    }
}