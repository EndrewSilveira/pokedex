package com.example.pokedex2.screen.detail.moves

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex2.R
import com.example.pokedex2.base.BaseAdapter
import com.example.pokedex2.domain.PokemonMove
import kotlinx.android.synthetic.main.adapter_detail_moves.view.*

class DetailMovesAdapter() : BaseAdapter<PokemonMove>() {

    override fun onCreateViewHolderBase(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent?.context)
            .inflate(R.layout.adapter_detail_moves, parent, false)
        return ViewHolder(view)
    }

    override fun <VH : RecyclerView.ViewHolder> onBindViewHolderBase(holder: VH, position: Int) {
        if (holder is ViewHolder) {
            val moveQuery = data[position]

            holder.itemView.tvMoveTitle.text = moveQuery.move.name.replace("-", " ")
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}