package com.alexvasin.littleworld.general.models.home.assembly

import androidx.navigation.NavController
import com.alexvasin.littleworld.general.models.home.model.HomeModel
import com.alexvasin.littleworld.general.models.home.router.HomeRouter
import com.alexvasin.littleworld.general.services.home.HomeService
import com.alexvasin.littleworld.general.ui.home.HomeViewModel

class HomeAssembly(private val navController: NavController): IHomeAssembly {
    override fun build(): HomeViewModel {
        val dataService = HomeService()
        val model = HomeModel(dataService)
        val router = HomeRouter(navController)
        return HomeViewModel(model, router)
    }
}