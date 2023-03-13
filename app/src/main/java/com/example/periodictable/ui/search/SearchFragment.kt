package com.example.periodictable.ui.search


import androidx.navigation.fragment.findNavController
import com.example.periodictable.adapter.OnItemClick
import com.example.periodictable.adapter.search.SearchAdapter
import com.example.periodictable.common.BaseFragment
import com.example.periodictable.databinding.FragmentSearchBinding
import com.example.periodictable.source.dummyData.ElementSearchDummyData
import com.example.periodictable.source.model.ElementsDetails
import com.example.periodictable.ui.HomeActivity
import com.example.periodictable.util.Abstract
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {
    private var dialogElementSearch: ArrayList<ElementsDetails> = arrayListOf()
    private lateinit var searchAdapter: SearchAdapter

    override fun definition() {
        dialogElementSearch.addAll(ElementSearchDummyData.listAdapter)

        with(binding) {
            searchAdapter = SearchAdapter(object : OnItemClick {
                override fun onClick(element: ElementsDetails) {
                    val action =
                        SearchFragmentDirections.actionSearchFragmentToBottomSheetFragment(element)
                    findNavController().navigate(action)
                }
            })
            searchAdapter.dialogElementArray = dialogElementSearch
            rViewSearch.adapter = searchAdapter
        }

        (requireActivity() as HomeActivity).backVisible(true)
    }

    override fun search() {
        val arrayElements = ArrayList<ElementsDetails>()
        binding.searchView.setOnQueryTextListener(object : Abstract.Search() {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    arrayElements.clear()
                    for (i in dialogElementSearch) {
                        if (i.elementDetail.contains(query)) {
                            arrayElements.add(i)
                        }
                    }
                    searchAdapter.filter(arrayElements)
                }
                return false
            }
        })
    }
}