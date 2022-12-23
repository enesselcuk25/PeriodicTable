package com.example.periodictable.source.model

import androidx.room.Entity


// Code with ❤️
//┌──────────────────────────┐
//│ Created by Enes SELÇUK │
//│ ──────────────────────── │
//│ enesselcuk@gmail.com      │            
//│ ──────────────────────── │
//│ 23.09.2021                │
//└──────────────────────────┘

sealed class PeriodicType {
    abstract fun getType(): Int

    enum class Type {
        ELEMENT,
        EMPTY
    }
}
