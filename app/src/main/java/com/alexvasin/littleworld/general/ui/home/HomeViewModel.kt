package com.alexvasin.littleworld.general.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexvasin.littleworld.general.datamodels.PersonData
import com.alexvasin.littleworld.general.models.home.model.IHomeModel
import com.alexvasin.littleworld.general.models.home.router.IHomeRouter

class HomeViewModel(
    private val model: IHomeModel,
    private val router: IHomeRouter
) : ViewModel(), IHomeView {
    var personData = MutableLiveData<ArrayList<PersonData>>()
    init {
        personDataInit(model.getPersonData())
    }
    private fun personDataInit(data: ArrayList<PersonData>) {
        personData.postValue(data)
    }
}