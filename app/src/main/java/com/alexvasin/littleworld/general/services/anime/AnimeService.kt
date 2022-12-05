package com.alexvasin.littleworld.general.services.anime

import com.alexvasin.littleworld.R
import com.alexvasin.littleworld.general.datamodels.AnimeCardData

class AnimeService: IAnimeService {
    override fun getAnimeData(): ArrayList<AnimeCardData> {
        return arrayListOf(
            AnimeCardData(
                R.drawable.owner_person,
                "Cocoro",
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
            )
        )
    }
}