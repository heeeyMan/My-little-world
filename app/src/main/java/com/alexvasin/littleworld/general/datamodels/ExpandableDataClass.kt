package com.alexvasin.littleworld.general.datamodels

data class ExpandableDataClass(
    val headerId: Int,
    val children: List<MoreInfoData>
)