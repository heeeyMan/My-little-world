package com.alexvasin.littleworld.general.models.anime.assembly

import com.alexvasin.littleworld.general.ui.list_of_anime.AnimeListViewModel

interface IAnimeAssembly {
    fun build(): AnimeListViewModel
}