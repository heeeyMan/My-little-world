package com.alexvasin.littleworld.general.ui.favorite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexvasin.littleworld.general.datamodels.AnimeCardData
import com.alexvasin.littleworld.general.models.favorite.model.IFavoriteModel
import com.alexvasin.littleworld.general.models.anime.router.IFavoriteRouter

class FavoriteAnimeViewModel(
    private val model: IFavoriteModel,
    private val router: IFavoriteRouter
) : ViewModel(), IFavoriteView {
    var favoriteData = MutableLiveData<List<AnimeCardData>>()
    init {
        favoriteDataInit(model.getFavoriteAnimeData())
    }
    private fun favoriteDataInit(data: List<AnimeCardData>) {
        favoriteData.postValue(data)
    }
    override fun showAnimeList(employeeDataModels: ArrayList<AnimeCardData>) {
        favoriteData.postValue(employeeDataModels)
    }

    override fun onItemClicked(position: Int) {
    }
}