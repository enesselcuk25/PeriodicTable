package com.example.periodictable.ui.dialog

import android.content.Intent
import android.net.Uri
import androidx.navigation.fragment.navArgs
import com.example.periodictable.R
import com.example.periodictable.common.BaseDialogFragment
import com.example.periodictable.databinding.FragmentElementDialogBinding
import com.example.periodictable.util.Ext.loadImage

class DialogElementsFragment :
    BaseDialogFragment<FragmentElementDialogBinding>(FragmentElementDialogBinding::inflate) {
    private val args: DialogElementsFragmentArgs by navArgs()
    override fun definition() {
        with(binding) {
            imaBtnClose.setOnClickListener {
                dialog?.dismiss()
            }

            alertLayout.setBackgroundResource(args.elements.backround ?: R.drawable.line_adapter_element)
            pNumber.text = args.elements.Index.toString()
            pName.text = args.elements.elementName
            pDetailName.text = args.elements.elementDetailName
            pImageName.loadImage(args.elements.imageElements)


            imageViewWikipedia.setOnClickListener {
                val url = "https://en.wikipedia.org/wiki/${args.elements.elementDetailName}"
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(browserIntent)
            }
        }
    }
}