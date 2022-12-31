package com.alexvasin.littleworld.general.datamodels

data class AllAnimeData(
    val icon: Int,
    val title: String,
    val rating: String,
    var isFavorite: Boolean,
    val description: String,
    val categories: ArrayList<String>,
    val link: String
)
