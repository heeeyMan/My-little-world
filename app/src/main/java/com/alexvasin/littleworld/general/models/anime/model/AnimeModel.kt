package com.alexvasin.littleworld.general.models.anime.model

import com.alexvasin.littleworld.general.datamodels.AnimeCardData
import com.alexvasin.littleworld.general.datamodels.SearchBarTextState
import com.alexvasin.littleworld.general.models.favorite.model.IFavoriteModel
import com.alexvasin.littleworld.general.services.anime.AnimeService
import com.alexvasin.littleworld.general.services.anime.IAnimeService

class AnimeModel(): IAnimeModel {

    private var fullEmployeeList: ArrayList<AnimeCardData> = arrayListOf()
    private var employeeListFiltered: MutableList<AnimeCardData> = mutableListOf()

    override fun getAnimeData(): ArrayList<AnimeCardData> {
        return AnimeService.getAnimeData()
    }
    override fun searchViewTextChanged(searchQuery: String?): Pair<ArrayList<AnimeCardData>, SearchBarTextState> {
        val filteredList = ArrayList<AnimeCardData>()

        when {
            fullEmployeeList.size == employeeListFiltered.size -> return Pair(
                fullEmployeeList,
                SearchBarTextState.SEARCH_BAR_TEXT_HIDDEN
            )
            !searchQuery.isNullOrEmpty() && searchQuery.first().toString() == " " -> return Pair(
                ArrayList(),
                SearchBarTextState.SEARCH_BAR_TEXT_NO_FIND
            )
            else -> fullEmployeeList.map {
            }

        }

        employeeListFiltered =
            filteredList
                .toMutableList()
        return if (employeeListFiltered.isEmpty()) {
            if (!searchQuery.isNullOrEmpty()) {
                Pair(ArrayList(), SearchBarTextState.SEARCH_BAR_TEXT_NO_FIND)
            } else {
                Pair(ArrayList(), SearchBarTextState.SEARCH_BAR_TEXT_EMPTY)
            }
        } else {
            Pair(ArrayList(), SearchBarTextState.SEARCH_BAR_TEXT_NO_FIND)
        }
    }

    override fun changeStateHeart(like: Boolean, position: Int) {
        AnimeService.changeLikeAnimeList(like, position)
    }
}