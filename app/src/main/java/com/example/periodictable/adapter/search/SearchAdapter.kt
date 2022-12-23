package com.example.periodictable.adapter.search


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.periodictable.adapter.OnItemClick
import com.example.periodictable.databinding.ItemSearchBinding
import com.example.periodictable.source.model.ElementsDetails


// Code with ❤️
//┌──────────────────────────┐
//│ Created by Enes SELÇUK │
//│ ──────────────────────── │
//│ enesselcuk@gmail.com      │            
//│ ──────────────────────── │
//│ 3.10.2021                │
//└──────────────────────────┘

class SearchAdapter(private val onClick: OnItemClick) :
    RecyclerView.Adapter<SearchViewHolder>() {

    var dialogElementArray: List<ElementsDetails> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val item = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(item)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
            holder.bind(dialogElementArray[position],onClick)
    }

    override fun getItemCount(): Int {
        return dialogElementArray.size
    }

    fun filter(filterArray: ArrayList<ElementsDetails>) {
        dialogElementArray = filterArray
        notifyDataSetChanged()
    }
}
