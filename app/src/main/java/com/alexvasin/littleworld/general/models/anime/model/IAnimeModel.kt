package com.alexvasin.littleworld.general.models.anime.model

import com.alexvasin.littleworld.general.datamodels.AnimeCardData

interface IAnimeModel {
    fun getAnimeData(): ArrayList<AnimeCardData>
}