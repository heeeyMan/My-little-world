package com.alexvasin.littleworld.general.services.anime

import com.alexvasin.littleworld.R
import com.alexvasin.littleworld.general.datamodels.AllAnimeData
import com.alexvasin.littleworld.general.datamodels.AnimeCardData

object AnimeService : IAnimeService {
    private var allAnimeData = mutableListOf<AllAnimeData>()
    private var cardAnimeList = mutableListOf<AnimeCardData>()

    init {
        allAnimeData = mutableListOf(
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
                title = "Aadfmk",
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
                title = "Drerert",
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
                title = "Kejfjfn",
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
                title = "Poooes",
                rating = "12.8",
                isFavorite = false,
                isViewed = false,
                description = "This anime is veeery coool! Please, bro, you must watch this! " +
                        "I would like to clear my memory, to watch this masterpiece again",
                categories = arrayListOf("Comedy, Advеnture, Etty, Horror"),
                link = "https://animego.org/anime"
            ),
            AllAnimeData(
                icon = R.drawable.owner_person,
                title = "Derh",
                rating = "2.8",
                isFavorite = false,
                isViewed = false,
                description = "This anime is veeery coool! Please, bro, you must watch this! " +
                        "I would like to clear my memory, to watch this masterpiece again",
                categories = arrayListOf("Comedy, Advеnture, Etty, Horror"),
                link = "https://animego.org/anime"
            ),
            AllAnimeData(
                icon = R.drawable.owner_person,
                title = "Rebf",
                rating = "12.8",
                isFavorite = false,
                isViewed = false,
                description = "This anime is veeery coool! Please, bro, you must watch this! " +
                        "I would like to clear my memory, to watch this masterpiece again",
                categories = arrayListOf("Comedy, Advеnture, Etty, Horror"),
                link = "https://animego.org/anime"
            ),
            AllAnimeData(
                icon = R.drawable.owner_person,
                title = "Kontr",
                rating = "10.0",
                isFavorite = false,
                isViewed = false,
                description = "This anime is veeery coool! Please, bro, you must watch this! " +
                        "I would like to clear my memory, to watch this masterpiece again",
                categories = arrayListOf("Comedy, Advеnture, Etty, Horror"),
                link = "https://animego.org/anime"
            ),
            AllAnimeData(
                icon = R.drawable.owner_person,
                title = "Forn",
                rating = "7.45",
                isFavorite = false,
                isViewed = false,
                description = "This anime is veeery coool! Please, bro, you must watch this! " +
                        "I would like to clear my memory, to watch this masterpiece again",
                categories = arrayListOf("Comedy, Advеnture, Etty, Horror"),
                link = "https://animego.org/anime"
            ),
            AllAnimeData(
                icon = R.drawable.owner_person,
                title = "Keern",
                rating = "8.18",
                isFavorite = false,
                isViewed = false,
                description = "This anime is veeery coool! Please, bro, you must watch this! " +
                        "I would like to clear my memory, to watch this masterpiece again",
                categories = arrayListOf("Comedy, Advеnture, Etty, Horror"),
                link = "https://animego.org/anime"
            ),
            AllAnimeData(
                icon = R.drawable.owner_person,
                title = "Ter",
                rating = "4.18",
                isFavorite = false,
                isViewed = false,
                description = "This anime is veeery coool! Please, bro, you must watch this! " +
                        "I would like to clear my memory, to watch this masterpiece again",
                categories = arrayListOf("Comedy, Advеnture, Etty, Horror"),
                link = "https://animego.org/anime"
            ),
            AllAnimeData(
                icon = R.drawable.owner_person,
                title = "Vnvjn",
                rating = "8.48",
                isFavorite = false,
                isViewed = false,
                description = "This anime is veeery coool! Please, bro, you must watch this! " +
                        "I would like to clear my memory, to watch this masterpiece again",
                categories = arrayListOf("Comedy, Advеnture, Etty, Horror"),
                link = "https://animego.org/anime"
            ),
            AllAnimeData(
                icon = R.drawable.owner_person,
                title = "Kmskln",
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
                title = "Dabf",
                rating = "3.58",
                isFavorite = false,
                isViewed = false,
                description = "This anime is veeery coool! Please, bro, you must watch this! " +
                        "I would like to clear my memory, to watch this masterpiece again",
                categories = arrayListOf("Comedy, Advеnture, Etty, Horror"),
                link = "https://animego.org/anime"
            ),
            AllAnimeData(
                icon = R.drawable.owner_person,
                title = "Habfhbjfb",
                rating = "11.8",
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
                isFavorite = true,
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

    override fun getAnimeItem(position: Int): AnimeCardData {
        return cardAnimeList[position]
    }

    override fun changeFavoriteStatusAnimeCard(isFavorite: Boolean, position: Int) {
        allAnimeData[position].isFavorite = isFavorite
        cardAnimeList[position].isFavorite = isFavorite
    }

    override fun getMoreInformationAboutCard(selectedCard: AnimeCardData): AllAnimeData? {
        return allAnimeData.find {
            (it.title == selectedCard.title) &&
                    (it.rating == selectedCard.rating) &&
                    (it.isFavorite == selectedCard.isFavorite)
        }
    }

    private fun updateAnimeCard() {
        cardAnimeList.clear()
        for (item in allAnimeData) {
            cardAnimeList.add(AnimeCardData(item.icon, item.title, item.rating, item.isFavorite))
        }
    }

}