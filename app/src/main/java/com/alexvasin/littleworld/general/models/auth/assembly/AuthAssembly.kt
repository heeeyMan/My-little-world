package com.alexvasin.littleworld.general.models.auth.assembly

import android.app.Activity
import com.alexvasin.littleworld.general.models.auth.model.AuthModel
import com.alexvasin.littleworld.general.models.auth.router.AuthRouter
import com.alexvasin.littleworld.general.services.auth.AuthService
import com.alexvasin.littleworld.general.ui.auth.AuthViewModel

class AuthAssembly(
    private val activity: Activity
    ): IAuthAssembly {
    override fun build(): AuthViewModel {
        val authService = AuthService()
        val router = AuthRouter(activity)
        val model = AuthModel(authService)
        return AuthViewModel(model, router)
    }
}