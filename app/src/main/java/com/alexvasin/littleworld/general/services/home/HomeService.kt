package com.alexvasin.littleworld.general.services.home

import com.alexvasin.littleworld.R
import com.alexvasin.littleworld.general.datamodels.ExpandableDataClass
import com.alexvasin.littleworld.general.datamodels.PersonData

class HomeService : IHomeService {
    override fun getPersonData(): ArrayList<PersonData> {
        return arrayListOf(
            PersonData(R.string.first_name, "Alexander"),
            PersonData(R.string.last_name, "Vasin"),
            PersonData(R.string.nickname, "Radiofucker")
        )
    }

    override fun getMoreInfoData(): List<ExpandableDataClass> {
        return listOf(
            ExpandableDataClass(
                R.string.general_info, listOf(
                    PersonData(R.string.birthday_date, "05.03.1999"),
                    PersonData(R.string.hometown, "Pervomaisk"),
                    PersonData(R.string.languages, "Russian, English"),
                )
            ),
            ExpandableDataClass(
                R.string.education, listOf(
                    PersonData(
                        R.string.university,
                        "N. I. Lobachevsky National Research University"
                    ),
                    PersonData(R.string.faculty, "Radiophysics"),
                    PersonData(R.string.specialization, "Radiophysics"),
                    PersonData(
                        R.string.department,
                        "Theory of oscillations and automatic regulation"
                    ),
                )
            ),
            ExpandableDataClass(
                R.string.experience, listOf(
                    PersonData(R.string.place, "N. I. Lobachevsky National Research University"),
                    PersonData(R.string.place, "SWTec"),
                    PersonData(R.string.place, "Central Research Institute of Burevestnik"),
                )
            ),
        )
    }
}