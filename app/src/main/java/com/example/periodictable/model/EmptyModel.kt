package com.example.periodictable.model

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Enes SELÇUK │
//│ ──────────────────────── │
//│ enesselcuk@gmail.com      │            
//│ ──────────────────────── │
//│ 20.09.2021                │
//└──────────────────────────┘

object EmptyModel:PeriodikType() {
    override fun getType(): Int {
        return Type.EMPTY.ordinal
    }

}


