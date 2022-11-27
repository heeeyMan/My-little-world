package com.alexvasin.littleworld.general.models.auth.model

import com.alexvasin.littleworld.general.services.auth.IAuthSevice

class AuthModel(
    private val dataService: IAuthSevice
    ): IAuthModel {
    override fun getAuthData(): String {
        return dataService.getAuthData()
    }
}