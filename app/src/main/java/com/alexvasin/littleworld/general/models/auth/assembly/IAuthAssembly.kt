package com.alexvasin.littleworld.general.models.auth.assembly

import com.alexvasin.littleworld.general.ui.auth.AuthViewModel

interface IAuthAssembly {
    fun build(): AuthViewModel
}