package com.example.periodictable.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VB : ViewDataBinding>(
    private val inflater: (LayoutInflater) -> VB
) : Fragment() {

     lateinit var binding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflater(layoutInflater)
      return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        definition()
        setObserver()
        swipe()
        search()
        setData()
        setClick()

    }

    open fun definition() {}
    open fun setObserver() {}
    open fun swipe() {}
    open fun search() {}
    open fun setData() {}
    open fun setClick() {}


}