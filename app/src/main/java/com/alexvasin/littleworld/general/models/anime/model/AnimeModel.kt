package com.alexvasin.littleworld.general.models.anime.model

import com.alexvasin.littleworld.general.datamodels.AnimeCardData
import com.alexvasin.littleworld.general.datamodels.SearchBarTextState
import com.alexvasin.littleworld.general.services.anime.AnimeService

class AnimeModel : IAnimeModel {
    private var fullEmployeeList: List<AnimeCardData> = arrayListOf()

    init {
        fullEmployeeList = getAnimeList()
    }

    override fun getAnimeListSortedAlphabet(): Map<Char, ArrayList<AnimeCardData>> {
        return AnimeService.getAnimeListSortedAlphabet()
    }

    override fun getAnimeListSortedRating(): Map<Float, ArrayList<AnimeCardData>> {
        return AnimeService.getAnimeListSortedRating()
    }

    override fun getAnimeList(): List<AnimeCardData> {
        return AnimeService.getAnimeList()
    }

    override fun getAnimeItem(position: Int): AnimeCardData {
        return AnimeService.getAnimeItem(position)
    }

    override fun searchViewTextChanged(searchQuery: String?): Pair<List<AnimeCardData>, SearchBarTextState> {
        var filteredList: List<AnimeCardData> = listOf()
        return if (searchQuery != null) {
            filteredList = fullEmployeeList.filter {
                it.title.lowercase().contains(searchQuery.lowercase())
            }
            when {
                filteredList.isEmpty() -> Pair(filteredList, SearchBarTextState.SEARCH_BAR_TEXT_NOT_FOUND)
                searchQuery == "" -> Pair(filteredList, SearchBarTextState.SEARCH_BAR_TEXT_EMPTY)

                else -> Pair(filteredList, SearchBarTextState.SEARCH_BAR_TEXT_HIDDEN)
            }

        } else {
            Pair(filteredList, SearchBarTextState.SEARCH_BAR_TEXT_EMPTY)
        }
    }

    override fun changeFavoriteState(isFavorite: Boolean, position: Int) {
        AnimeService.changeFavoriteStatusAnimeCard(isFavorite, position)
    }
}