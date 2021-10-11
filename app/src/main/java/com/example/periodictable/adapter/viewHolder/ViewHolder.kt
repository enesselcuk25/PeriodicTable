package com.example.periodictable.adapter.viewHolder

import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.periodictable.R
import com.example.periodictable.databinding.AdapterElementsBinding
import com.example.periodictable.model.Elements

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Enes SELÇUK   │
//│ ──────────────────────── │
//│ enesselcuk@gmail.com     │
//│ ──────────────────────── │
//│ 19.09.2021               │
//└──────────────────────────┘

class ViewHolder(val binding: AdapterElementsBinding, private val onElementClick: (Int) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {


    init {
        itemView.setOnClickListener {
            onElementClick(adapterPosition)
        }
    }

    fun bind(elements: Elements) {
        binding.element = elements
        binding.layouPeriodik.animation =
            AnimationUtils.loadAnimation(itemView.context, R.anim.item_animation)
    }
} 
