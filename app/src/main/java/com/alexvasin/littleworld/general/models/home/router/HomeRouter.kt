package com.alexvasin.littleworld.general.models.home.router

import androidx.navigation.NavController
import com.alexvasin.littleworld.general.ui.home.HomeFragmentDirections

class HomeRouter(
    private val navController: NavController
) : IHomeRouter {
    override fun navigationToFavorite() {
        navController.navigate(HomeFragmentDirections.actionNavigationHomeToNavigationFavoriteAnime())
    }
}