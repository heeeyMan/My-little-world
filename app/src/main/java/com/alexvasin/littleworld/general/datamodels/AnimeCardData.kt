package com.alexvasin.littleworld.general.datamodels

data class AnimeCardData(
    val icon: Int,
    val title: String,
    val subTitle: String,
    var isFavorite: Boolean
)