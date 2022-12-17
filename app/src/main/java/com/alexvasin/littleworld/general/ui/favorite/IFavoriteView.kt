package com.alexvasin.littleworld.general.ui.favorite

import com.alexvasin.littleworld.general.datamodels.AnimeCardData

interface IFavoriteView {
    fun onItemClicked(position: Int)
    fun showAnimeList(employeeDataModels: ArrayList<AnimeCardData>)
}