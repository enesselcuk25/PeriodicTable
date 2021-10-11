package com.example.periodictable.adapter.viewHolder
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.periodictable.R
import com.example.periodictable.databinding.ItemSearchBinding
import com.example.periodictable.model.DialogElements


// Code with ❤️
//┌──────────────────────────┐
//│ Created by Enes SELÇUK   │
//│ ──────────────────────── │
//│ enesselcuk@gmail.com     │
//│ ──────────────────────── │
//│ 3.10.2021                │
//└──────────────────────────┘

class SearchViewHolder(val binding: ItemSearchBinding):RecyclerView.ViewHolder(binding.root) {

    fun bind(dialogElements: DialogElements,onItemClick:onItemClick) {
           binding.search = dialogElements

             // Animation
          binding.searcCardView.animation = AnimationUtils.loadAnimation(itemView.context, R.anim.rcycler_animation)


        binding.searcCardView.setOnClickListener {
            onItemClick.onClick(dialogElements)
        }


    }
} 
