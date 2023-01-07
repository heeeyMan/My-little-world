package com.alexvasin.littleworld.general.services.anime

import com.alexvasin.littleworld.R
import com.alexvasin.littleworld.general.datamodels.AnimeCardData

object AnimeService : IAnimeService {
    private var animeData = arrayListOf<AnimeCardData>()
    private var animeList = arrayListOf<AnimeCardData>()
    private var favoriteAnime = listOf<AnimeCardData>()

    init {
        animeData = arrayListOf(
            AnimeCardData(
                R.drawable.owner_person,
                "Start",
                "7.10",
                false
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Bala",
                "9.8",
                true
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Gaka",
                "3.8",
                false
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Derad",
                "5.8",
                false
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Alfa",
                "8.8",
                true
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Hint",
                "7.9",
                true
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Derad",
                "5.8",
                false
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Alfa",
                "8.8",
                true
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Hint",
                "7.9",
                true
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Hint",
                "7.9",
                true
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Derad",
                "5.8",
                false
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Alfa",
                "8.8",
                true
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "END",
                "7.9",
                true
            )
        )
        animeList = animeData
        favoriteAnime = animeList.filter { it.isFavorite }
    }

    override fun getAnimeData(): ArrayList<AnimeCardData> {
        return animeList
    }

    override fun getFavoriteData(): List<AnimeCardData> {
        return favoriteAnime
    }

    override fun changeLikeAnimeList(like: Boolean, position: Int) {
        animeList[position].isFavorite = like
        favoriteAnime = animeList.filter { it.isFavorite }
    }
}