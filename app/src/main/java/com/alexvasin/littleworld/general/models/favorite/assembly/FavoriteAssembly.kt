package com.alexvasin.littleworld.general.models.favorite.assembly

import com.alexvasin.littleworld.general.models.favorite.model.FavoriteModel
import com.alexvasin.littleworld.general.models.favorite.router.FavoriteRouter
import com.alexvasin.littleworld.general.ui.favorite.FavoriteAnimeViewModel

class FavoriteAssembly : IFavoriteAssembly {
    override fun build(): FavoriteAnimeViewModel {
        val model = FavoriteModel()
        val router = FavoriteRouter()
        return FavoriteAnimeViewModel(model, router)
    }
}