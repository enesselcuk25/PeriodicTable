package com.example.periodictable.ui


import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.periodictable.R
import com.example.periodictable.databinding.ActivityMainBinding
import com.example.periodictable.util.PreferencesDataStoreStatus.dataStoreLangKey
import com.example.periodictable.util.PreferencesDataStoreStatus.dataStoreLanguage
import com.example.periodictable.util.PreferencesDataStoreStatus.updateLanguage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fullScreen()
        getLanguage()
        initViews()
    }


    private fun fullScreen() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    private fun initViews(){
        with(binding){
            click = this@HomeActivity
        }
    }
    fun toSearchFrag() {
       findNavController(R.id.nav_host_fragment).navigate(R.id.searchFragment)
    }
    fun toSettingsFrag() {
        findNavController(R.id.nav_host_fragment).navigate(R.id.settingFragment)
    }
    fun toBack(){
        findNavController(R.id.nav_host_fragment).popBackStack()
    }

    fun backVisible(visible:Boolean){
        if(visible){
            binding.includeToolbar.imageBack.visibility = View.VISIBLE
        }else {
            binding.includeToolbar.imageBack.visibility = View.GONE
        }
    }


    @RequiresApi(Build.VERSION_CODES.N)
    private fun getLanguage(): Context {
        val context = baseContext
        lifecycleScope.launch(Dispatchers.Main) {
            baseContext.dataStoreLanguage.data.collectLatest {
                when (it[dataStoreLangKey]) {
                    "tr" -> {
                        updateLanguage(context, "tr")
                    }
                    "en" -> {
                        updateLanguage(context, "en")
                    }
                }
            }
        }
        return context
    }
}