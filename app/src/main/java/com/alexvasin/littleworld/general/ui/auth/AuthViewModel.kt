package com.alexvasin.littleworld.general.ui.auth

import androidx.lifecycle.ViewModel
import com.alexvasin.littleworld.general.models.auth.model.IAuthModel
import com.alexvasin.littleworld.general.models.auth.router.IAuthRouter

class AuthViewModel(private val model: IAuthModel,
                    private val router: IAuthRouter
                    ) : ViewModel(), IAuthView {
    override fun pressedEnter(password: String) {
        if (password == model.getAuthData()) {
            //router.openHomeScreen()
        }
        router.openHomeScreen()
    }

    override fun pressedHelp() {
        TODO("Not yet implemented")
    }

    override fun pressedVisiblePassword() {
        TODO("Not yet implemented")
    }

}