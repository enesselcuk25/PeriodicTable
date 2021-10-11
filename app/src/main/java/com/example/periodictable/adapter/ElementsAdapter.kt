package com.example.periodictable.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.periodictable.databinding.AdapterElementsBinding
import com.example.periodictable.model.Elements
import com.example.periodictable.databinding.AdapterItemEmptyBinding
import com.example.periodictable.model.EmptyModel
import com.example.periodictable.model.PeriodikType
import com.example.periodictable.adapter.viewHolder.EmptyViewHolder
import com.example.periodictable.adapter.viewHolder.ViewHolder


// Code with ❤️
//┌──────────────────────────┐
//│ Created by Enes SELÇUK   │
//│ ──────────────────────── │
//│ enesselcuk@gmail.com     │
//│ ──────────────────────── │
//│ 13.09.2021               │
//└──────────────────────────┘

class ElementsAdapter(private val onElementOnclick:(Elements) -> Unit):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var listModel : List<PeriodikType> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

       return when(viewType) {
            PeriodikType.Type.ELEMENT.ordinal -> {
                val itemView = AdapterElementsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                ViewHolder(itemView) {
                    onElementOnclick(listModel[it] as Elements)
                }
            }
            PeriodikType.Type.EMPTY.ordinal -> {
                val itemView = AdapterItemEmptyBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                EmptyViewHolder(itemView)
            }
            else -> {
                throw Exception("Unkown view type exception")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(listModel[position]){
            is Elements -> {
                (holder as ViewHolder).bind(listModel[position] as Elements)
            }
            is EmptyModel -> {
                (holder as EmptyViewHolder)
            }
        }
    }

    override fun getItemCount(): Int {
        return listModel.size
    }

    override fun getItemViewType(position: Int): Int {
        return (listModel[position].getType())
    }
} 
