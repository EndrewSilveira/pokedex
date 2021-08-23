package com.example.pokedex2.screen.home

import android.graphics.drawable.Drawable
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex2.R
import com.example.pokedex2.base.BaseAdapter
import com.example.pokedex2.domain.Pokemon
import com.example.pokedex2.domain.PokemonSpecies
import kotlinx.android.synthetic.main.layout_pokedex_item.*
import kotlinx.android.synthetic.main.layout_pokedex_item.view.*
import java.util.*

class PokedexAdapter(val favorited: MutableList<Pokemon>): BaseAdapter<Pokemon>() {

    private val mDataList: MutableList<Pokemon> by lazy { mutableListOf<Pokemon>() }
    var onItemClick: ((pokemon : Pokemon) -> Unit)? = null
    var onFavorited: ((pokemon : Pokemon) -> Unit)? = null
    var onFavoritedRemoved: ((pokemon : Pokemon) -> Unit)? = null

    override fun onCreateViewHolderBase(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.layout_pokedex_item, parent, false)
        return ViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun <VH : RecyclerView.ViewHolder> onBindViewHolderBase(holder: VH, position: Int) {
        if (holder is ViewHolder) {
            val filledHeart = ContextCompat.getDrawable(holder.itemView.context, R.drawable.ic_fav_filled)
            val pokemonQuery = data[position]

            pokemonQuery?.let {

                if (favorited.contains(pokemonQuery))
                holder.itemView.ivFavoriteIcon.background = filledHeart
                else holder.itemView.ivFavoriteIcon.background = null

                Glide.with(holder.itemView.context)
                    .load(it.imageUrl)
                    .into(holder.ivPokemonImage)

                holder.txtCode.text = "# ${pokemonQuery.formattedNumber}"
                holder.txtName.text = pokemonQuery.formattedName
                holder.txtType1.text = pokemonQuery.types[0].name.capitalize(Locale.ROOT)

                if (pokemonQuery.types.size > 1) {
                    holder.txtType2.isVisible = true
                    holder.txtType2.text = pokemonQuery.types[1].name.capitalize(Locale.ROOT)
                } else {
                    holder.txtType2.isVisible = false
                }
                PokemonTypeStyle(holder.itemView.txtType1, holder.itemView.cvPokemonCard).styleTypeSlotOne(holder.itemView)
            }

            holder.itemView.setOnClickListener {
                onItemClick?.invoke(pokemonQuery)
            }
            holder.itemView.setOnLongClickListener {
                if (it.ivFavoriteIcon.background == null) {
                    it.ivFavoriteIcon.background = filledHeart
                    onFavorited?.invoke(pokemonQuery)
                } else {
                    it.ivFavoriteIcon.background = null
                    onFavoritedRemoved?.invoke(pokemonQuery)
                }
                true
            }
        }
    }

    override fun getItemCount() = data.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivPokemonImage: AppCompatImageView = itemView.ivPokemonImage
        val txtCode: AppCompatTextView = itemView.txtCode
        val txtName: AppCompatTextView = itemView.txtName
        val txtType1: AppCompatTextView = itemView.txtType1
        val txtType2: AppCompatTextView = itemView.txtType2
    }

    override fun setData(list: List<Pokemon>) {
        super.setData(list)
    }
}