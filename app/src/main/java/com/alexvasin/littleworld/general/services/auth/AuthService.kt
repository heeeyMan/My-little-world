package com.alexvasin.littleworld.general.services.auth

class AuthService: IAuthService {
    override fun getAuthData(): String {
        return "world"
    }
}