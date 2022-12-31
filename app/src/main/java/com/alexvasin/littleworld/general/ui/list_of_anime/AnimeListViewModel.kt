package com.alexvasin.littleworld.general.ui.list_of_anime

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexvasin.littleworld.general.datamodels.AnimeCardData
import com.alexvasin.littleworld.general.datamodels.SearchBarTextState
import com.alexvasin.littleworld.general.models.anime.model.IAnimeModel
import com.alexvasin.littleworld.general.models.anime.router.IAnimeRouter

class AnimeListViewModel(
    private val model: IAnimeModel,
    private val router: IAnimeRouter
) : ViewModel(), IAnimeView {
    var animeData = MutableLiveData<Map<Char, ArrayList<AnimeCardData>>>()
    val searchBarTextState: MutableLiveData<SearchBarTextState> = MutableLiveData()

    init {
        animeDataInit(model.getAnimeData())
    }

    private fun animeDataInit(data: Map<Char, ArrayList<AnimeCardData>>) {
        animeData.postValue(data)
    }

    fun searchViewCollapsed() {
        searchBarTextState.postValue(SearchBarTextState.SEARCH_BAR_TEXT_HIDDEN)
    }

    fun searchViewExpanded() {
        searchBarTextState.postValue(SearchBarTextState.SEARCH_BAR_TEXT_EMPTY)
    }

    override fun showAnimeList(employeeDataModels: Map<Char, ArrayList<AnimeCardData>>) {
        animeData.postValue(employeeDataModels)
    }

    override fun heartClick(like: Boolean, position: Int) {
        model.changeStateHeart(like, position)
        animeDataInit(model.getAnimeData())
    }

    override fun showNotFoundError(errorState: SearchBarTextState) {
        searchBarTextState.postValue(errorState)
    }

    override fun handleChangeTextSearchView(query: String?) {
        val filteredList = model.searchViewTextChanged(query)
        showNotFoundError(filteredList.second)
    }

}