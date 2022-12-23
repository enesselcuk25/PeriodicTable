package com.example.periodictable.ui.dialog

import android.content.Intent
import androidx.lifecycle.lifecycleScope
import com.example.periodictable.R
import com.example.periodictable.common.BaseDialogFragment
import com.example.periodictable.databinding.LanguageDialogFragmentBinding
import com.example.periodictable.ui.HomeActivity
import com.example.periodictable.util.PreferencesDataStoreStatus.setLanguage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DialogLanguageFragment :
    BaseDialogFragment<LanguageDialogFragmentBinding>(LanguageDialogFragmentBinding::inflate) {

    override fun definition() {
        with(binding) {
            radioGroup.setOnCheckedChangeListener { group, checkedId ->
                when (checkedId) {
                    R.id.radioBtn_tr -> {
                        lifecycleScope.launch {
                            setLanguage(requireContext(), "tr")
                            delay(1000L)
                            val intent = Intent(requireContext(), HomeActivity::class.java)
                            requireActivity().finish()
                            startActivity(intent)
                        }
                    }
                    R.id.radioBtn_en -> {
                        lifecycleScope.launch {
                            setLanguage(requireContext(), "en")
                            delay(1000L)
                            val intent = Intent(requireContext(), HomeActivity::class.java)
                            requireActivity().finish()
                            startActivity(intent)
                        }
                    }
                }
            }
        }
    }


}