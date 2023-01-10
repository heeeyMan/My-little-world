package com.alexvasin.littleworld.general.services.anime

import com.alexvasin.littleworld.R
import com.alexvasin.littleworld.general.datamodels.AllAnimeData
import com.alexvasin.littleworld.general.datamodels.AnimeCardData

object AnimeService : IAnimeService {
    private var allAnimeData = arrayListOf<AllAnimeData>()
    private var cardAnimeList = listOf<AnimeCardData>()

    init {
        allAnimeData = arrayListOf(
            AllAnimeData(
                icon = R.drawable.owner_person,
                title = "Start",
                rating = "8.8",
                isFavorite = false,
                isViewed = false,
                description = "This anime is veeery coool! Please, bro, you must watch this! " +
                        "I would like to clear my memory, to watch this masterpiece again",
                categories = arrayListOf("Comedy, Advеnture, Etty, Horror"),
                link = "https://animego.org/anime"
            ),
            AllAnimeData(
                icon = R.drawable.owner_person,
                title = "Afmk",
                rating = "1.8",
                isFavorite = false,
                isViewed = false,
                description = "This anime is veeery coool! Please, bro, you must watch this! " +
                        "I would like to clear my memory, to watch this masterpiece again",
                categories = arrayListOf("Comedy, Advеnture, Etty, Horror"),
                link = "https://animego.org/anime"
            ),
            AllAnimeData(
                icon = R.drawable.owner_person,
                title = "Dert",
                rating = "9.8",
                isFavorite = false,
                isViewed = false,
                description = "This anime is veeery coool! Please, bro, you must watch this! " +
                        "I would like to clear my memory, to watch this masterpiece again",
                categories = arrayListOf("Comedy, Advеnture, Etty, Horror"),
                link = "https://animego.org/anime"
            ),
            AllAnimeData(
                icon = R.drawable.owner_person,
                title = "Ken",
                rating = "6.8",
                isFavorite = false,
                isViewed = false,
                description = "This anime is veeery coool! Please, bro, you must watch this! " +
                        "I would like to clear my memory, to watch this masterpiece again",
                categories = arrayListOf("Comedy, Advеnture, Etty, Horror"),
                link = "https://animego.org/anime"
            ),
            AllAnimeData(
                icon = R.drawable.owner_person,
                title = "Yes",
                rating = "3.8",
                isFavorite = false,
                isViewed = false,
                description = "This anime is veeery coool! Please, bro, you must watch this! " +
                        "I would like to clear my memory, to watch this masterpiece again",
                categories = arrayListOf("Comedy, Advеnture, Etty, Horror"),
                link = "https://animego.org/anime"
            ),
            AllAnimeData(
                icon = R.drawable.owner_person,
                title = "End",
                rating = "9.8",
                isFavorite = false,
                isViewed = false,
                description = "This anime is veeery coool! Please, bro, you must watch this! " +
                        "I would like to clear my memory, to watch this masterpiece again",
                categories = arrayListOf("Comedy, Advеnture, Etty, Horror"),
                link = "https://animego.org/anime"
            )
        )
        updateAnimeCard()
    }

    override fun getAnimeListSortedAlphabet(): Map<Char, ArrayList<AnimeCardData>> {
        val animeListSortedAlphabet = mapOf<Char, ArrayList<AnimeCardData>>()
        for (item in cardAnimeList) {
            animeListSortedAlphabet[item.title[0]]?.add(item)
        }
        return animeListSortedAlphabet
    }

    override fun getAnimeListSortedRating(): Map<Float, ArrayList<AnimeCardData>> {
        val animeListSortedRating = mapOf<Float, ArrayList<AnimeCardData>>()
        for (item in cardAnimeList) {
            animeListSortedRating[item.rating.toFloat()]?.add(item)
        }
        return animeListSortedRating
    }

    override fun getFavoriteAnimeList(): List<AnimeCardData> {
        return cardAnimeList.filter { it.isFavorite }
    }

    override fun getAnimeList(): List<AnimeCardData> {
        return cardAnimeList
    }

    override fun changeFavoriteStatusAnimeCard(isFavorite: Boolean, position: Int) {
        allAnimeData[position].isFavorite = isFavorite
        updateAnimeCard()
    }

    override fun changeViewedStatusAnimeCard(isViewed: Boolean, position: Int) {
        allAnimeData[position].isViewed = isViewed
        updateAnimeCard()
    }

    override fun getMoreInformationAboutCard(selectedCard: AnimeCardData): AllAnimeData? {
        return allAnimeData.find {
            (it.title == selectedCard.title) &&
            (it.rating == selectedCard.rating) &&
            (it.isFavorite == selectedCard.isFavorite)
        }
    }

    private fun updateAnimeCard() {
        cardAnimeList = cardAnimeList.map {
            AnimeCardData(it.icon, it.title, it.rating, it.isFavorite)
        }
    }

}