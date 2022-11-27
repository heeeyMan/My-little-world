package com.alexvasin.littleworld.general.datamodels

import com.alexvasin.littleworld.R

enum class PersonData(val personDataField: Int,
                      val personDataContent: String?) {
    FIRST_NAME(R.string.first_name, "Alexander"),
    LAST_NAME(R.string.last_name, "Vasin"),
    PATRONYMIC(R.string.patronymic, "Sergeevich")
}