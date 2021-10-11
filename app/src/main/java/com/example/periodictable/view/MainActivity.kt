package com.example.periodictable.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.periodictable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.replace(HomeFragment(),"Home",backFragment = HomeFragment::class.java.simpleName )
    }

    private fun FragmentManager.replace(fragment: Fragment, frag:String, backFragment: String){
        beginTransaction().replace(binding.framLayout.id,fragment,frag).addToBackStack(backFragment).commit()
    }



    fun frameClick(item: android.view.MenuItem) {
        supportFragmentManager.replace(SearchFragment(),"search",HomeFragment::class.java.simpleName)
    }

}