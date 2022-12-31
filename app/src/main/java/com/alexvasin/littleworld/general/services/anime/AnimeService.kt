package com.alexvasin.littleworld.general.services.anime

import com.alexvasin.littleworld.R
import com.alexvasin.littleworld.general.datamodels.AnimeCardData

object AnimeService : IAnimeService {
    private var animeData = arrayListOf<AnimeCardData>()
    private var animeList = arrayListOf<AnimeCardData>()
    private var favoriteAnime = listOf<AnimeCardData>()
    private var sortAnimeList = mapOf<Char, ArrayList<AnimeCardData>>()

    init {
        animeData = arrayListOf(
            AnimeCardData(
                R.drawable.owner_person,
                "Start",
                "7.8",
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
                "Sart",
                "7.8",
                false
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Sbala",
                "9.8",
                true
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Scaka",
                "3.8",
                false
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Snrad",
                "5.8",
                false
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Scfa",
                "8.8",
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
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Aastart",
                "7.8",
                false
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Abala",
                "9.8",
                true
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Acfa",
                "8.8",
                true
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Azint",
                "7.9",
                true
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Zart",
                "7.8",
                false
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Zbabala",
                "9.8",
                true
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Zend",
                "3.8",
                false
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Cart",
                "7.8",
                false
            ),
            AnimeCardData(
                R.drawable.owner_person,
                "Cbala",
                "9.8",
                true
            ),
        )
        for(item in animeData) {
            sortAnimeList[item.title[0]]?.add(item)
        }
        animeList = animeData
        favoriteAnime = animeList.filter { it.isFavorite }
    }

    override fun getAnimeData(): Map<Char, ArrayList<AnimeCardData>> {
        return sortAnimeList
    }

    override fun getFavoriteData(): List<AnimeCardData> {
        return favoriteAnime
    }

    override fun changeLikeAnimeList(like: Boolean, position: Int) {
        animeList[position].isFavorite = like
        favoriteAnime = animeList.filter { it.isFavorite }
    }
}