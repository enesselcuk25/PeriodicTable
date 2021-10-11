package com.example.periodictable.util

import android.content.Context
import android.view.LayoutInflater
import com.example.periodictable.databinding.AlertDesignBinding
import com.example.periodictable.databinding.SearchDialogBinding
import com.example.periodictable.model.DialogElements
import com.example.periodictable.model.Elements


object Dialog {

    fun searchDialog(context: Context, list: DialogElements){
        val binding = SearchDialogBinding.inflate(LayoutInflater.from(context))
        val dialog = context.let { android.app.Dialog(it) }
        dialog.setContentView(binding.root)
        binding.searchDialog = list
        dialog.show()
        binding.imageBClose.setOnClickListener{dialog.dismiss()}

    }

    fun homeDialog(context: Context,elementsList:Elements){
        val binding = AlertDesignBinding.inflate(LayoutInflater.from(context))
        val dialog = context.let { android.app.Dialog(it) }

        dialog.setContentView(binding.root)
        binding.alert = elementsList
        dialog.show()
        binding.imaBtnClose.setOnClickListener { dialog.dismiss() }

    }
}