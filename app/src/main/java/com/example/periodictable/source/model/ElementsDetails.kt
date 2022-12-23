package com.example.periodictable.source.model

import android.os.Parcelable
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import androidx.room.ColumnInfo


@Parcelize
data class ElementsDetails(
    @ColumnInfo(name = "element") val element: String?,
    @ColumnInfo(name = "element_detail") val elementDetail: String,
    @ColumnInfo(name = "standart_state") val standartState: String?,
    @ColumnInfo(name = "atomic") val atomic: String?,
    @ColumnInfo(name = "electron") val electron: String?,
    @ColumnInfo(name = "oxidation") val oxidation: String?,
    @ColumnInfo(name = "electronegativity") val electronegativity: String?,
    @ColumnInfo(name = "atomic_radius") val atomicRadius: String?,
    @ColumnInfo(name = "ionization") val ionization: String?,
    @ColumnInfo(name = "electron_affinity") val electronAffinity: String?,
    @ColumnInfo(name = "melting") val Melting: String?,
    @ColumnInfo(name = "boiling") val Boiling: String?,
    @ColumnInfo(name = "density") val Density: String?,
    @ColumnInfo(name = "year") val Year: String?,
    @ColumnInfo(name = "atomic_number") val number: Int?,
    @PrimaryKey val id: Int? = null,
) : Parcelable {
    val image: String
    get() = "https://images-of-elements.com/s/" + elementDetail.lowercase() + ".jpg"

}
