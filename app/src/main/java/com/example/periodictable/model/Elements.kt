package com.example.periodictable.model

import androidx.annotation.ColorRes

data class Elements
    (
    val Index: Int,
    val ElementName: String?,
    val ElementDetailName: String?,
    var position: Int = 0,
    @ColorRes val Baccround:Int,
    @ColorRes val textColor:Int

):PeriodikType() {
    override fun getType(): Int {
        return Type.ELEMENT.ordinal
    }

val imageElements : String
    get() = "https://images-of-elements.com/s/" + ElementDetailName?.lowercase() + ".jpg"
}