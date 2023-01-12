package com.alexvasin.littleworld.general.datamodels

import com.alexvasin.littleworld.R

enum class SearchBarTextState {
    SEARCH_BAR_TEXT_EMPTY,
    SEARCH_BAR_TEXT_NOT_FOUND,
    SEARCH_BAR_TEXT_HIDDEN;

    fun getMessageId(): Int? {
        return when (this) {
            SEARCH_BAR_TEXT_EMPTY -> R.string.empty_request
            SEARCH_BAR_TEXT_NOT_FOUND -> R.string.not_found
            SEARCH_BAR_TEXT_HIDDEN -> null
        }
    }

    fun isVisible(): Boolean {
        return when (this) {
            SEARCH_BAR_TEXT_HIDDEN -> true
            SEARCH_BAR_TEXT_EMPTY, SEARCH_BAR_TEXT_NOT_FOUND -> false
        }
    }
}
