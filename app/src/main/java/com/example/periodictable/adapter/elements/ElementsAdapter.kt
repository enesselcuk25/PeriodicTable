package com.example.periodictable.adapter.elements


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.periodictable.source.model.Elements
import com.example.periodictable.databinding.AdapterItemEmptyBinding
import com.example.periodictable.source.model.EmptyModel
import com.example.periodictable.source.model.PeriodicType
import com.example.periodictable.adapter.elements.viewHolder.EmptyViewHolder
import com.example.periodictable.adapter.elements.viewHolder.ViewHolder
import com.example.periodictable.databinding.ItemElementsBinding


// Code with ❤️
//┌──────────────────────────┐
//│ Created by Enes SELÇUK   │
//│ ──────────────────────── │
//│ enesselcuk@gmail.com     │
//│ ──────────────────────── │
//│ 13.09.2021               │
//└──────────────────────────┘

class ElementsAdapter(private val onElementOnclick:(Elements) -> Unit):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var listModel : List<PeriodicType> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

       return when(viewType) {
            PeriodicType.Type.ELEMENT.ordinal -> {
                val itemView = ItemElementsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                ViewHolder(itemView) {
                    onElementOnclick(listModel[it] as Elements)
                }
            }
            PeriodicType.Type.EMPTY.ordinal -> {
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
