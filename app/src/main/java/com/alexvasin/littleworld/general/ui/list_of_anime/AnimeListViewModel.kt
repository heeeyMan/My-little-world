package com.alexvasin.littleworld.general.ui.list_of_anime

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexvasin.littleworld.general.datamodels.AnimeCardData
import com.alexvasin.littleworld.general.datamodels.SearchBarState
import com.alexvasin.littleworld.general.datamodels.SearchBarTextState
import com.alexvasin.littleworld.general.models.anime.model.IAnimeModel
import com.alexvasin.littleworld.general.models.anime.router.IAnimeRouter

class AnimeListViewModel(
    private val model: IAnimeModel,
    private val router: IAnimeRouter
) : ViewModel(), IAnimeView {
    var animeListSortedAlphabet = MutableLiveData<Map<Char, ArrayList<AnimeCardData>>>()
    var animeListSortedRating = MutableLiveData<Map<Float, ArrayList<AnimeCardData>>>()
    var animeList = MutableLiveData<List<AnimeCardData>?>()
    var animeItemUpdate = MutableLiveData<Pair<AnimeCardData, Int>>()
    val searchBarTextState: MutableLiveData<SearchBarTextState> = MutableLiveData()
    val searchBarState: MutableLiveData<SearchBarState> = MutableLiveData()

    init {
        updateAnimeList(model.getAnimeList())
    }

    override fun heartClick(isFavorite: Boolean, position: Int) {
        model.changeFavoriteState(isFavorite, position)
        updateAnimeItem(model.getAnimeItem(position), position)
    }

    override fun showSearchBarTextState(state: SearchBarTextState) {
        searchBarTextState.postValue(state)
    }

    override fun showSearchBarState(state: SearchBarState) {
        searchBarState.postValue(state)
    }

    override fun handleChangeTextSearchView(query: String?) {
        val filteredList = model.searchViewTextChanged(query)
        showSearchBarTextState(filteredList.second)
        updateAnimeList(filteredList.first)
    }

    fun searchViewCollapsed() {
        showSearchBarState(SearchBarState.COLLAPSED)
        updateAnimeList(model.getAnimeList())
    }

    fun searchViewExpanded() {
        showSearchBarState(SearchBarState.EXPANDED)
    }

    private fun updateAnimeList(data: List<AnimeCardData>) {
        animeList.postValue(data)
    }
    private fun updateAnimeItem(item: AnimeCardData, position: Int) {
        animeItemUpdate.postValue(Pair(item, position))
    }
}