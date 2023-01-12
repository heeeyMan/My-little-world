package com.alexvasin.littleworld.general.ui.list_of_anime

import com.alexvasin.littleworld.general.datamodels.SearchBarState
import com.alexvasin.littleworld.general.datamodels.SearchBarTextState

interface IAnimeView {
    fun showSearchBarTextState(state: SearchBarTextState)
    fun showSearchBarState(state: SearchBarState)
    fun handleChangeTextSearchView(query: String?)
    fun heartClick(isFavorite: Boolean, position: Int)
}