package com.example.periodictable.adapter.search

import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.periodictable.R
import com.example.periodictable.adapter.OnItemClick
import com.example.periodictable.databinding.ItemSearchBinding
import com.example.periodictable.source.model.ElementsDetails


// Code with ❤️
//┌──────────────────────────┐
//│ Created by Enes SELÇUK   │
//│ ──────────────────────── │
//│ enesselcuk@gmail.com     │
//│ ──────────────────────── │
//│ 3.10.2021                │
//└──────────────────────────┘

class SearchViewHolder(val binding: ItemSearchBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(dialogElements: ElementsDetails, onItemClick: OnItemClick) {

        with(binding) {
            search = dialogElements
            constrainLayout.animation =
                AnimationUtils.loadAnimation(itemView.context, R.anim.rcycler_animation)
            constrainLayout.setOnClickListener {
                onItemClick.onClick(dialogElements)
            }
        }

    }
} 
