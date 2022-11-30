package com.alexvasin.littleworld.general.services.home

import com.alexvasin.littleworld.R
import com.alexvasin.littleworld.general.datamodels.ExpandableDataClass
import com.alexvasin.littleworld.general.datamodels.MoreInfoData
import com.alexvasin.littleworld.general.datamodels.PersonData

class HomeService : IHomeService {
    override fun getPersonData(): ArrayList<PersonData> {
        return arrayListOf(
            PersonData(R.string.first_name, "Alexander"),
            PersonData(R.string.last_name, "Vasin"),
            PersonData(R.string.patronymic, "Sergeevich")
        )
    }

    override fun getMoreInfoData(): List<ExpandableDataClass> {
        return listOf(
            ExpandableDataClass(
                R.string.general_info, listOf(
                    MoreInfoData(R.string.birthday_date, "05.03.1999"),
                    MoreInfoData(R.string.hometown, "Pervomaisk"),
                    MoreInfoData(R.string.languages, "Russian, English"),
                )
            ),
            ExpandableDataClass(
                R.string.education, listOf(
                    MoreInfoData(
                        R.string.university,
                        "N. I. Lobachevsky National Research University"
                    ),
                    MoreInfoData(R.string.faculty, "Radiophysics"),
                    MoreInfoData(R.string.specialization, "Radiophysics"),
                    MoreInfoData(
                        R.string.department,
                        "Theory of oscillations and automatic regulation"
                    ),
                )
            ),
            ExpandableDataClass(
                R.string.experience, listOf(
                    MoreInfoData(R.string.place, "N. I. Lobachevsky National Research University"),
                    MoreInfoData(R.string.place, "SWTec"),
                    MoreInfoData(R.string.place, "Central Research Institute of Burevestnik"),
                )
            ),
        )
    }
}