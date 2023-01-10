package com.alexvasin.littleworld.general.models.anime.model

import com.alexvasin.littleworld.general.datamodels.AnimeCardData
import com.alexvasin.littleworld.general.datamodels.SearchBarTextState

interface IAnimeModel {
    fun searchViewTextChanged(searchQuery: String?): Pair<List<AnimeCardData>, SearchBarTextState>
    fun getAnimeListSortedAlphabet(): Map<Char, ArrayList<AnimeCardData>>
    fun getAnimeListSortedRating(): Map<Float, ArrayList<AnimeCardData>>
    fun getAnimeList(): List<AnimeCardData>
    fun changeFavoriteState(like: Boolean, position: Int)
    fun changeViewedState(like: Boolean, position: Int)
}