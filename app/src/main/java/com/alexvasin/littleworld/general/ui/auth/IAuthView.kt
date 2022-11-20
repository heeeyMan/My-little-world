package com.alexvasin.littleworld.general.ui.auth

interface IAuthView {
    fun pressedEnter(password: String)
    fun pressedHelp()
    fun pressedVisiblePassword()
}