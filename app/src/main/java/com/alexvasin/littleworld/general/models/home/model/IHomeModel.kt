package com.alexvasin.littleworld.general.models.home.model

import com.alexvasin.littleworld.general.datamodels.PersonData

interface IHomeModel {
    fun getPersonData(): ArrayList<PersonData>
}