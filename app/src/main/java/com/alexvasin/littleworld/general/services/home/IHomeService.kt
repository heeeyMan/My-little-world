package com.alexvasin.littleworld.general.services.home

import com.alexvasin.littleworld.general.datamodels.ExpandableDataClass
import com.alexvasin.littleworld.general.datamodels.PersonData

interface IHomeService {
    fun getPersonData(): ArrayList<PersonData>
    fun getMoreInfoData(): List<ExpandableDataClass>
}