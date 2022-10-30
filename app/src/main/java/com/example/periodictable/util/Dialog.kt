package com.example.periodictable.util

import android.content.Context
import android.view.LayoutInflater
import com.example.periodictable.databinding.SearchDialogBinding
import com.example.periodictable.source.model.ElementsDetails
import com.example.periodictable.source.model.Elements


object Dialog {

    fun searchDialog(context: Context, list: ElementsDetails) {
        val binding = SearchDialogBinding.inflate(LayoutInflater.from(context))
        val dialog = context.let { android.app.Dialog(it) }
        dialog.setContentView(binding.root)
        binding.searchDialog = list
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
        binding.imageBClose.setOnClickListener { dialog.dismiss() }
    }

//    fun homeDialog(context: Context, elementsList: Elements) {
//        val binding = ElementDialogBinding.inflate(LayoutInflater.from(context))
//        val dialog = context.let { android.app.Dialog(it) }
//
//        dialog.setContentView(binding.root)
//        binding.alert = elementsList
//        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
//        dialog.show()
//        binding.imaBtnClose.setOnClickListener { dialog.dismiss() }
//    }
}