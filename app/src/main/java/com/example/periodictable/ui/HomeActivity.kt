package com.example.periodictable.ui


import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
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
    }


    private fun fullScreen() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
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