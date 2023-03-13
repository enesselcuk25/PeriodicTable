package com.example.periodictable.source.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
data class Elements(
    @ColumnInfo(name = "index") val Index: Int,
    @ColumnInfo(name = "element_name") val elementName: String?,
    @ColumnInfo(name = "element_detail_name") val elementDetailName: String?,
    @ColumnInfo(name = "backround") val backround: Int? = null,
    @ColumnInfo(name = "text_colour") val textColor: Int? = null,
    @PrimaryKey val id: Int? = null,
) : Parcelable, PeriodicType() {
    override fun getType(): Int {
        return Type.ELEMENT.ordinal
    }

    val imageElements: String
        get() = "https://images-of-elements.com/s/" + elementDetailName?.lowercase() + ".jpg"

}