package com.alexvasin.littleworld.general.services.anime

import com.alexvasin.littleworld.general.datamodels.AllAnimeData
import com.alexvasin.littleworld.general.datamodels.AnimeCardData

interface IAnimeService {
    fun getAnimeListSortedAlphabet(): Map<Char, ArrayList<AnimeCardData>>
    fun getAnimeListSortedRating(): Map<Float, ArrayList<AnimeCardData>>
    fun getFavoriteAnimeList(): List<AnimeCardData>
    fun getAnimeList(): List<AnimeCardData>
    fun changeFavoriteStatusAnimeCard(isFavorite: Boolean, position: Int)
    fun changeViewedStatusAnimeCard(isViewed: Boolean, position: Int)
    fun getMoreInformationAboutCard(selectedCard: AnimeCardData): AllAnimeData?
}