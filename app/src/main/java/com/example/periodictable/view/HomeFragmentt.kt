package com.example.periodictable.view


import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.periodictable.R
import com.example.periodictable.adapter.ElementsAdapter
import com.example.periodictable.databinding.FragmentHomeBinding
import com.example.periodictable.dummyData.ElementsDummyData
import com.example.periodictable.model.Elements
import com.example.periodictable.util.Dialog.homeDialog


class HomeFragment : Fragment() {

   private lateinit var binding: FragmentHomeBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (context as AppCompatActivity).setSupportActionBar(binding.toolbar)
        setHasOptionsMenu(true)

        val adapter = ElementsAdapter {
            onCLickElement(it)
        }
        adapter.listModel = ElementsDummyData.listAdapter
        binding.recView.adapter = adapter

        binding.recView.layoutManager = GridLayoutManager(view.context,13,LinearLayoutManager.HORIZONTAL,false)

    }

    private fun onCLickElement(element:Elements) {

        context?.let {homeDialog(it,element) }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_fragment_navigate,menu)

        super.onCreateOptionsMenu(menu, inflater)
    }


}