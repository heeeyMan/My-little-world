package com.alexvasin.littleworld.general.models.auth.router

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.alexvasin.littleworld.general.ui.activities.MainActivity

class AuthRouter(
    private val activity: Activity
    ): IAuthRouter {
    override fun openHomeScreen() {
        val intent = Intent(activity, MainActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }
}