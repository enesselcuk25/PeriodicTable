package com.example.periodictable.ui.dialog

import android.content.Intent
import android.net.Uri
import androidx.navigation.fragment.navArgs
import com.example.periodictable.common.BaseDialogFragment
import com.example.periodictable.databinding.FragmentElementDialogBinding

class DialogElementsFragment :
    BaseDialogFragment<FragmentElementDialogBinding>(FragmentElementDialogBinding::inflate) {
    private val args: DialogElementsFragmentArgs by navArgs()
    override fun definition() {
        with(binding) {
            elements = args.elements
            imaBtnClose.setOnClickListener {
                dialog?.dismiss()
            }
            imageViewWikipedia.setOnClickListener {
                val url = "https://en.wikipedia.org/wiki/${args.elements.elementDetailName}"
                val browserIntent =
                    Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(browserIntent)
            }
        }
    }
}