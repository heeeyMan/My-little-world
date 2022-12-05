package com.alexvasin.littleworld.general.models.anime.model

import com.alexvasin.littleworld.general.datamodels.AnimeCardData
import com.alexvasin.littleworld.general.services.anime.IAnimeService

class AnimeModel(private val animeService: IAnimeService): IAnimeModel {
    override fun getAnimeData(): ArrayList<AnimeCardData> {
        return animeService.getAnimeData()
    }
}