package com.alexvasin.littleworld.general.models.favorite.model

import com.alexvasin.littleworld.general.datamodels.AnimeCardData
import com.alexvasin.littleworld.general.services.anime.AnimeService

class FavoriteModel(): IFavoriteModel {

    override fun getFavoriteAnimeData(): List<AnimeCardData> {
        return AnimeService.getFavoriteData()
    }
}