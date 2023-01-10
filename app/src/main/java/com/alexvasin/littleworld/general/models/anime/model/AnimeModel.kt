package com.alexvasin.littleworld.general.models.anime.model

import com.alexvasin.littleworld.general.datamodels.AnimeCardData
import com.alexvasin.littleworld.general.datamodels.SearchBarTextState
import com.alexvasin.littleworld.general.services.anime.AnimeService

class AnimeModel(): IAnimeModel {

    private var fullEmployeeList: ArrayList<AnimeCardData> = arrayListOf()

    override fun getAnimeListSortedAlphabet(): Map<Char, ArrayList<AnimeCardData>> {
        return AnimeService.getAnimeListSortedAlphabet()
    }

    override fun getAnimeListSortedRating(): Map<Float, ArrayList<AnimeCardData>> {
        return AnimeService.getAnimeListSortedRating()
    }

    override fun getAnimeList(): List<AnimeCardData> {
        return AnimeService.getAnimeList()
    }

    override fun searchViewTextChanged(searchQuery: String?): Pair<ArrayList<AnimeCardData>, SearchBarTextState> {
        val filteredList = ArrayList<AnimeCardData>()
        return Pair(arrayListOf(), SearchBarTextState.SEARCH_BAR_TEXT_HIDDEN)
    }

    override fun changeFavoriteState(like: Boolean, position: Int) {
        AnimeService.changeFavoriteStatusAnimeCard(like, position)
    }

    override fun changeViewedState(like: Boolean, position: Int) {
        TODO("Not yet implemented")
    }
}