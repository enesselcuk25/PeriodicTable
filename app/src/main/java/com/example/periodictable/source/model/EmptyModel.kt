package com.example.periodictable.source.model

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Enes SELÇUK │
//│ ──────────────────────── │
//│ enesselcuk@gmail.com      │            
//│ ──────────────────────── │
//│ 20.09.2021                │
//└──────────────────────────┘

object EmptyModel: PeriodicType() {
    override fun getType(): Int {
        return Type.EMPTY.ordinal
    }

}


