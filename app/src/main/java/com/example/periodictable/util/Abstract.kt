package com.example.periodictable.util

import android.app.Application
import androidx.appcompat.widget.SearchView
import com.example.periodictable.PeriodicApplication

object Abstract {

    abstract class Search():SearchView.OnQueryTextListener{
        override fun onQueryTextChange(newText: String?): Boolean {
            return false
        }

        override fun onQueryTextSubmit(query: String?): Boolean {
            return false
        }
    }


}