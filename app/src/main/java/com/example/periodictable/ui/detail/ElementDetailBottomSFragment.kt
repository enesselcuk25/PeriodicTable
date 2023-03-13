package com.example.periodictable.ui.detail

import android.content.Intent
import android.net.Uri
import androidx.navigation.fragment.navArgs
import com.example.periodictable.R
import com.example.periodictable.common.BaseBottomFragment
import com.example.periodictable.databinding.FragmentBottomSheetBinding
import com.example.periodictable.ui.HomeActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ElementDetailBottomSFragment :
    BaseBottomFragment<FragmentBottomSheetBinding>(FragmentBottomSheetBinding::inflate) {
    val args: ElementDetailBottomSFragmentArgs by navArgs()
    private val arrayLink: ArrayList<String> = arrayListOf()
    override fun defination() {
        args.elementWiki.let {
            binding.dataSet = it
            arrayLink.clear()
            arrayLink.add(it.elementDetail)
        }
        binding.click = this@ElementDetailBottomSFragment

        (requireActivity() as HomeActivity).backVisible(true)
    }

    fun linkClick() {
        if (!arrayLink.isNullOrEmpty()) {
            val url = "https://en.wikipedia.org/wiki/${arrayLink[0]}"
            val browserIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(browserIntent)
        }
    }

    override fun getTheme(): Int = R.style.CustomBottomSheetDialog

}