package com.example.pokedex2.screen.home

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class RecyclerViewScrollListener : RecyclerView.OnScrollListener() {

    private var oldY = 0
    var currentPage = 0
    var currentLimit = 20
    abstract fun onLoadMore(limit: Int,offset: Int)

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        val layoutManager = recyclerView.layoutManager as? GridLayoutManager
        if (layoutManager != null) {
            val visibleItemCount = layoutManager.childCount
            val totalItemCount = layoutManager.itemCount
            val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
            val isScrollingToEnd = dy < oldY
            oldY = dy

            if (isScrollingToEnd && visibleItemCount + firstVisibleItemPosition >= totalItemCount) {
                val offset = currentPage + 20
                val limit = currentLimit + 20
                onLoadMore(limit, offset)
                currentPage = offset
            }
        }
    }
}