package com.alexvasin.littleworld.general.models.favorite.model

import com.alexvasin.littleworld.general.datamodels.AnimeCardData

interface IFavoriteModel {
    fun getFavoriteAnimeData(): List<AnimeCardData>
}