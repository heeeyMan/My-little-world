package com.alexvasin.littleworld.general.datamodels

import com.alexvasin.littleworld.R

enum class SearchBarTextState {
    SEARCH_BAR_TEXT_EMPTY,
    SEARCH_BAR_TEXT_NO_FIND,
    SEARCH_BAR_TEXT_HIDDEN;

    fun getHeaderId(): Int? {
        return when (this) {
            SEARCH_BAR_TEXT_EMPTY -> R.string.start_search_header
            SEARCH_BAR_TEXT_NO_FIND -> R.string.start_search_message
            SEARCH_BAR_TEXT_HIDDEN -> null
        }
    }

    fun getMessageId(): Int? {
        return when (this) {
            SEARCH_BAR_TEXT_EMPTY -> R.string.start_search_message
            SEARCH_BAR_TEXT_NO_FIND -> R.string.start_search_header
            SEARCH_BAR_TEXT_HIDDEN -> null
        }
    }

    fun isVisible(): Boolean {
        return when (this) {
            SEARCH_BAR_TEXT_HIDDEN -> false
            SEARCH_BAR_TEXT_EMPTY, SEARCH_BAR_TEXT_NO_FIND -> true
        }
    }
}
