package com.example.periodictable.adapter.elements.viewHolder

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.periodictable.R
import com.example.periodictable.databinding.ItemElementsBinding
import com.example.periodictable.source.model.Elements

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Enes SELÇUK   │
//│ ──────────────────────── │
//│ enesselcuk@gmail.com     │
//│ ──────────────────────── │
//│ 19.09.2021               │
//└──────────────────────────┘

class ViewHolder(
    val binding: ItemElementsBinding,
    private val onElementClick: (Int) -> Unit, ) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        itemView.setOnClickListener {
            onElementClick.invoke(adapterPosition)
        }
    }

    fun bind(elements: Elements) {
        with(binding) {
            element = elements
            homeLayouPeriodik.animation =
                AnimationUtils.loadAnimation(itemView.context, R.anim.item_animation)
            homeLayouPeriodik.background = ColorDrawable(Color.TRANSPARENT)


        }
    }
} 
