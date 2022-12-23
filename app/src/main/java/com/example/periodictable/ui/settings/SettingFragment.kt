package com.example.periodictable.ui.settings

import android.content.Intent
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.periodictable.R
import com.example.periodictable.common.BaseFragment
import com.example.periodictable.databinding.FragmentSettingsBinding
import com.example.periodictable.util.PreferencesDataStoreStatus
import com.example.periodictable.util.PreferencesDataStoreStatus.dataStore
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SettingFragment : BaseFragment<FragmentSettingsBinding>(FragmentSettingsBinding::inflate) {

    override fun definition() {
        bannerAdMob()
        with(binding) {
            textviewLanguageChange.setOnClickListener {
                findNavController().navigate(R.id.dialogLanguageFragment)
            }
            linearLayoutTema.setOnClickListener {
                findNavController().navigate(R.id.dialogTypeFragment)
            }
            linearlayoutShare.setOnClickListener {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(
                        Intent.EXTRA_TEXT,
                        "https://play.google.com/store/apps/details?id=com.enes.Egezegenler"
                    )
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }
        darkOrLight()
    }

    private fun darkOrLight() {
        lifecycleScope.launch {
            requireContext().dataStore.data.map {
                when (it[PreferencesDataStoreStatus.dataStoreDarkKey]) {
                    true -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        binding.textviewThemeChoose.text =
                            requireContext().getString(R.string.dark_type)
                    }
                    false -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                        binding.textviewThemeChoose.text =
                            requireContext().getString(R.string.light_type)
                    }
                    else -> {
                        throw Exception("oops")
                    }
                }
            }
        }
    }

    private fun bannerAdMob() {
        MobileAds.initialize(requireContext())
        val request = AdRequest.Builder().build()

        val adView = AdView(requireContext())
        adView.setAdSize(AdSize.BANNER)
        adView.adUnitId = "ca-app-pub-9758804960858015/3483529680"
        binding.adView.loadAd(request)
    }
}