package com.alexvasin.littleworld.general.models.home.model

import com.alexvasin.littleworld.general.datamodels.ExpandableDataClass
import com.alexvasin.littleworld.general.datamodels.PersonData
import com.alexvasin.littleworld.general.services.home.IHomeService

class HomeModel(private val dataService: IHomeService) : IHomeModel {
    override fun getPersonData(): ArrayList<PersonData> {
        return dataService.getPersonData()
    }

    override fun getMoreInfoData(): List<ExpandableDataClass> {
        return dataService.getMoreInfoData()
    }
}