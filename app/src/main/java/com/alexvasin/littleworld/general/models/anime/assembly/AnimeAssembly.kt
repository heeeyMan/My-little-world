package com.alexvasin.littleworld.general.models.anime.assembly

import com.alexvasin.littleworld.general.models.anime.model.AnimeModel
import com.alexvasin.littleworld.general.models.anime.router.AnimeRouter
import com.alexvasin.littleworld.general.services.anime.AnimeService
import com.alexvasin.littleworld.general.ui.list_of_anime.AnimeListViewModel

class AnimeAssembly: IAnimeAssembly {
    override fun build(): AnimeListViewModel {
        val model = AnimeModel()
        val router = AnimeRouter()
        return AnimeListViewModel(model, router)
    }
}