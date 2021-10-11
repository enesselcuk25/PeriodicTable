package com.example.periodictable.model


// Code with ❤️
//┌──────────────────────────┐
//│ Created by Enes SELÇUK │
//│ ──────────────────────── │
//│ enesselcuk@gmail.com      │            
//│ ──────────────────────── │
//│ 23.09.2021                │
//└──────────────────────────┘
sealed class PeriodikType {
    abstract fun getType(): Int

    enum class Type {
        ELEMENT,
        EMPTY
    }
}
