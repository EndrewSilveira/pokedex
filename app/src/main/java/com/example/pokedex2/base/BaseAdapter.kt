package com.example.pokedex2.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mDataList: MutableList<T> by lazy { mutableListOf<T>() }

    abstract fun onCreateViewHolderBase(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        viewType: Int
    ): RecyclerView.ViewHolder

    abstract fun <VH : RecyclerView.ViewHolder> onBindViewHolderBase(
        holder: VH,
        position: Int
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return onCreateViewHolderBase(inflater, parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        this.onBindViewHolderBase(holder, position)
    }

    override fun getItemCount() = mDataList.size

    protected fun getItem(index: Int) = mDataList[index]

    val data: MutableList<T>
        get() = mDataList

    fun addItem(item: T) {
        mDataList.add(item)
        notifyItemInserted(if (itemCount > 0) mDataList.lastIndex else 0)
    }

    fun addItem(position: Int, item: T) {
        mDataList.add(position, item)
        notifyItemInserted(position)
    }

    fun removeItem(position: Int) {
        if (mDataList.isEmpty()) {
            return
        }

        this.mDataList.removeAt(position)
        this.notifyItemRemoved(position)
    }

    fun clearData() {
        this.mDataList.clear()
        this.notifyDataSetChanged()
    }

    fun addData(list: List<T>) {
        val firstItemPosition = this.mDataList.lastIndex + 1
        this.mDataList.addAll(list)
        this.notifyItemRangeInserted(firstItemPosition, list.size)
    }

    open fun setData(list: List<T>) {
        mDataList.clear()
        mDataList.addAll(list)
        notifyDataSetChanged()
    }

    fun updateItem(position: Int, item: T) {
        mDataList[position] = item
        notifyDataSetChanged()
    }
}