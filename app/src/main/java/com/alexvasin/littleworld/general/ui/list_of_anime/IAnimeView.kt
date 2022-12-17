package com.alexvasin.littleworld.general.ui.list_of_anime

import com.alexvasin.littleworld.general.datamodels.AnimeCardData
import com.alexvasin.littleworld.general.datamodels.SearchBarTextState

interface IAnimeView {
    fun showNotFoundError(errorState: SearchBarTextState)
    fun handleChangeTextSearchView(query: String?)
    fun showAnimeList(employeeDataModels: ArrayList<AnimeCardData>)
    fun heartClick(like: Boolean, position: Int)
}