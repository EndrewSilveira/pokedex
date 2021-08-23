package com.example.pokedex2.screen.detail.about.weakness

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex2.R
import com.example.pokedex2.base.BaseAdapter
import com.example.pokedex2.domain.PokemonType
import com.example.pokedex2.screen.home.PokemonTypeStyle
import kotlinx.android.synthetic.main.adapter_weakness.view.*
import kotlinx.android.synthetic.main.fragment_detail_about.view.*
import java.util.*

class WeaknessAdapter(): BaseAdapter<PokemonType>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolderBase(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.adapter_weakness, parent, false)
        return ViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun <VH : RecyclerView.ViewHolder> onBindViewHolderBase(holder: VH, position: Int) {
        val weakness = data[position]

        holder.itemView.tvWeaknessName.text = weakness.name

        PokemonTypeStyle(null, holder.itemView.cvWeakness).styleWeakness(holder.itemView, weakness.name.capitalize(Locale.ROOT), holder.itemView.ivWeaknessIcon)
    }
}