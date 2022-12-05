package com.alexvasin.littleworld.general.services.anime

import com.alexvasin.littleworld.general.datamodels.AnimeCardData

interface IAnimeService {
    fun getAnimeData(): ArrayList<AnimeCardData>
}