package com.example.periodictable.common

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.example.periodictable.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseDialogFragment<VB : ViewDataBinding>(private val layoutInflater: (LayoutInflater) -> VB) :
    DialogFragment() {

    lateinit var binding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = layoutInflater(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requireDialog().window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        definition()


        super.onViewCreated(view, savedInstanceState)
    }

    open fun definition() {}

}