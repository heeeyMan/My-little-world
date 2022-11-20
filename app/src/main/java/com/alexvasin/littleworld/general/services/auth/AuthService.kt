package com.alexvasin.littleworld.general.services.auth

class AuthService: IAuthSevice {
    override fun getAuthData(): String {
        return "world"
    }
}