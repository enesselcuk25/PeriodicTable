package com.example.periodictable

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.example.periodictable.util.PreferencesDataStoreStatus
import com.example.periodictable.util.PreferencesDataStoreStatus.dataStore
import com.example.periodictable.util.PreferencesDataStoreStatus.dataStoreLangKey
import com.example.periodictable.util.PreferencesDataStoreStatus.dataStoreLanguage
import com.example.periodictable.util.PreferencesDataStoreStatus.updateLanguage
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.N)
@HiltAndroidApp
class PeriodicApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        getLanguage()
        darkStatus()
    }

    private fun darkStatus(): Context {
        val context = baseContext
        with(ProcessLifecycleOwner.get()) {
            lifecycleScope.launch(Dispatchers.Main) {
                context.dataStore.data.collectLatest {
                    when(it[PreferencesDataStoreStatus.dataStoreDarkKey]){
                        true ->  AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        false -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                        else -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

                    }

                }
            }
        }
        return context
    }

    private fun getLanguage(): Context {
        val context = baseContext
        with(ProcessLifecycleOwner.get()) {
            lifecycleScope.launch(Dispatchers.Main) {
                context.dataStoreLanguage.data.collectLatest {
                    if (it[dataStoreLangKey] == "en") {
                        updateLanguage(context, "en")
                    } else {
                        updateLanguage(context, "tr")
                    }
                }
            }
        }
        return context
    }
}