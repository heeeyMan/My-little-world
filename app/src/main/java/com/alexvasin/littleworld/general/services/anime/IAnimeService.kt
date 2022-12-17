package com.alexvasin.littleworld.general.services.anime

import com.alexvasin.littleworld.general.datamodels.AnimeCardData

interface IAnimeService {
    fun getAnimeData(): ArrayList<AnimeCardData>
    fun getFavoriteData(): List<AnimeCardData>
    fun changeLikeAnimeList(like: Boolean, position: Int)
}