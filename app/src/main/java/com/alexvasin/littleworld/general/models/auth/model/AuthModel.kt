package com.alexvasin.littleworld.general.models.auth.model

import com.alexvasin.littleworld.general.services.auth.IAuthService

class AuthModel(
    private val dataService: IAuthService
    ): IAuthModel {
    override fun getAuthData(): String {
        return dataService.getAuthData()
    }
}