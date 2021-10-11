package com.example.periodictable.view

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.periodictable.R
import com.example.periodictable.adapter.SerachAdapter
import com.example.periodictable.adapter.viewHolder.onItemClick
import com.example.periodictable.databinding.FragmentSearchBinding
import com.example.periodictable.dummyData.ElementSearchDummyData
import com.example.periodictable.model.DialogElements
import com.example.periodictable.util.Dialog
import androidx.appcompat.widget.SearchView
import kotlin.collections.ArrayList


class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    lateinit var dialogElements: DialogElements

    private  var dialogElementSearch:ArrayList<DialogElements> = arrayListOf()
    private lateinit var  adapter : SerachAdapter

    private  var elementSearch:ArrayList<DialogElements> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (context as AppCompatActivity).setSupportActionBar(binding.toolbar)
        setHasOptionsMenu(true)

        dialogElementSearch.addAll(ElementSearchDummyData.listAdapter)
        elementSearch.addAll(dialogElementSearch)


        adapter = SerachAdapter (object : onItemClick{
            override fun onClick(elementh: DialogElements) {
                context?.let { Dialog.searchDialog(it,elementh) }
            }
        })
        binding.rViewSearch.layoutManager = LinearLayoutManager(context)
        adapter.dialogElementArray = ElementSearchDummyData.listAdapter
        binding.rViewSearch.adapter = adapter

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_fragment_navigate,menu)

        val item = menu.findItem(R.id.search)

        val searcview = item?.actionView as SearchView
        searcview.maxWidth = Int.MAX_VALUE


        searcview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filter(newText)
             return true
            }
        } )

        return super.onCreateOptionsMenu(menu, inflater)
    }
    private fun filter(test:String?){
        val filterArrayList = ArrayList<DialogElements>()

        for(a in dialogElementSearch){

            if(a.elementDeatail.lowercase().contains(test!!.lowercase())){
                filterArrayList.add(a)
            }
        }
        if(filterArrayList.isNotEmpty()){
            adapter.filter(filterArrayList)
        }
    }
}