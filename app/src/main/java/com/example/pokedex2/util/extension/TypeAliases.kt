package com.example.pokedex2.util.extension

import android.view.View

typealias OnItemClickListener<T> = ((view: View, position: Int, data: T) -> Unit)
typealias OnNavigationResult<R> = ((result: R) -> Unit)
typealias OnTextChangeListener<String> = ((text: String) -> Unit)