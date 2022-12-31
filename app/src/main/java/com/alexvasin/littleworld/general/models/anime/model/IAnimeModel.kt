package com.alexvasin.littleworld.general.models.anime.model

import com.alexvasin.littleworld.general.datamodels.AnimeCardData
import com.alexvasin.littleworld.general.datamodels.SearchBarTextState

interface IAnimeModel {
    fun getAnimeData(): Map<Char, ArrayList<AnimeCardData>>
    fun searchViewTextChanged(searchQuery: String?): Pair<List<AnimeCardData>, SearchBarTextState>
    fun changeStateHeart(like: Boolean, position: Int)
}