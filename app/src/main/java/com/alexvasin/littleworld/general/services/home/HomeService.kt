package com.alexvasin.littleworld.general.services.home

import com.alexvasin.littleworld.general.datamodels.PersonData

class HomeService : IHomeService {
    override fun getPersonData(): ArrayList<PersonData> {
        return arrayListOf(
            PersonData.FIRST_NAME,
            PersonData.LAST_NAME,
            PersonData.PATRONYMIC
        )
    }
}