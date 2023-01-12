package com.alexvasin.littleworld.general.datamodels

import com.alexvasin.littleworld.R

enum class SearchBarState {
    EXPANDED,
    COLLAPSED;
    fun isVisible(): Boolean {
        return when (this) {
            EXPANDED -> false
            COLLAPSED -> true
        }
    }
    fun getMessageId(): Int? {
        return when (this) {
            EXPANDED -> R.string.empty_request
            COLLAPSED -> null
        }
    }
}