package com.alexvasin.littleworld.general.ui.list_of_anime

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexvasin.littleworld.general.datamodels.AnimeCardData
import com.alexvasin.littleworld.general.models.anime.model.IAnimeModel
import com.alexvasin.littleworld.general.models.anime.router.IAnimeRouter

class AnimeListViewModel(
    private val model: IAnimeModel,
    private val router: IAnimeRouter
) : ViewModel() {
    var animeData = MutableLiveData<ArrayList<AnimeCardData>>()
    init {
        animeDataInit(model.getAnimeData())
    }
    private fun animeDataInit(data: ArrayList<AnimeCardData>) {
        animeData.postValue(data)
    }
}