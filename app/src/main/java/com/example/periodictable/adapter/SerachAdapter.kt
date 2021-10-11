package com.example.periodictable.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.periodictable.adapter.viewHolder.SearchViewHolder
import com.example.periodictable.adapter.viewHolder.onItemClick
import com.example.periodictable.databinding.ItemSearchBinding
import com.example.periodictable.model.DialogElements



// Code with ❤️
//┌──────────────────────────┐
//│ Created by Enes SELÇUK │
//│ ──────────────────────── │
//│ enesselcuk@gmail.com      │            
//│ ──────────────────────── │
//│ 3.10.2021                │
//└──────────────────────────┘

class SerachAdapter(private val onClick:onItemClick): RecyclerView.Adapter<SearchViewHolder>(){

    var dialogElementArray : List<DialogElements> = arrayListOf()
    set(value) {
        field = value
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
       return SearchViewHolder(ItemSearchBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {

        holder.bind(dialogElementArray[position],onClick)
    }

    override fun getItemCount(): Int {
        return dialogElementArray.size
    }

     fun filter( filterArray : ArrayList<DialogElements>){
        dialogElementArray = filterArray
        notifyDataSetChanged()
    }

}
