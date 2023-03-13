package com.example.periodictable.ui.home


import android.content.ContentValues.TAG
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.periodictable.R
import com.example.periodictable.adapter.elements.ElementsAdapter
import com.example.periodictable.common.BaseFragment
import com.example.periodictable.databinding.FragmentHomeBinding
import com.example.periodictable.source.dummyData.ElementsDummyData
import com.example.periodictable.source.model.Elements
import com.example.periodictable.ui.HomeActivity
import com.example.periodictable.util.PreferencesDataStoreStatus.status
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private var mInterstitialAd: InterstitialAd? = null
    private lateinit var elementsAdapter: ElementsAdapter

    override fun definition() {
        elementsAdapter = ElementsAdapter {
            onCLickElement(it)
        }

        with(binding) {
            click = this@HomeFragment
            recView.adapter = elementsAdapter
        }
        elementsAdapter.listModel = ElementsDummyData.listAdapter
        bannerAdMob()

        (requireActivity() as HomeActivity).backVisible(false)
    }

    private fun onCLickElement(element: Elements) {
        val action = HomeFragmentDirections.actionHomeFragmentToDialogElementsFragment(element)
        findNavController().navigate(action)
    }

    private fun bannerAdMob() {
        MobileAds.initialize(requireContext())
        val request = AdRequest.Builder().build()

        val adView = AdView(requireContext())
        adView.setAdSize(AdSize.BANNER)
        adView.adUnitId = "ca-app-pub-9758804960858015/3483529680"
        binding.adView.loadAd(request)
    }

//    private fun admobInterested() {
//        /**
//         * interstitial
//         */
//
//        MobileAds.initialize(requireContext())
//        val request = AdRequest.Builder().build()
//
//        InterstitialAd.load(requireContext(), "ca-app-pub-3940256099942544/1033173712",
//            request, object : InterstitialAdLoadCallback() {
//                override fun onAdFailedToLoad(p0: LoadAdError) {
//                    mInterstitialAd = null
//                }
//
//                override fun onAdLoaded(interstitialAd: InterstitialAd) {
//                    mInterstitialAd = interstitialAd
//                }
//            })
//
//        if (mInterstitialAd != null) {
//            mInterstitialAd?.show(requireActivity())
//        } else {
//            Log.d("TAG", "The interstitial ad wasn't ready yet.")
//        }
//
//        mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
//            override fun onAdClicked() {
//                // Called when a click is recorded for an ad.
//                Log.d(TAG, "Ad was clicked.")
//            }
//
//            override fun onAdDismissedFullScreenContent() {
//                // Called when ad is dismissed.
//                Log.d(TAG, "Ad dismissed fullscreen content.")
//                mInterstitialAd = null
//            }
//
//            override fun onAdFailedToShowFullScreenContent(p0: AdError) {
//                super.onAdFailedToShowFullScreenContent(p0)
//            }
//
//            override fun onAdImpression() {
//                // Called when an impression is recorded for an ad.
//                Log.d(TAG, "Ad recorded an impression.")
//            }
//
//            override fun onAdShowedFullScreenContent() {
//                // Called when ad is shown.
//                Log.d(TAG, "Ad showed fullscreen content.")
//            }
//        }
//
//    }

}