package com.example.periodictable.ui.dialog

import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import com.example.periodictable.R
import com.example.periodictable.common.BaseDialogFragment
import com.example.periodictable.databinding.TypeDialogFragmentBinding
import com.example.periodictable.util.PreferencesDataStoreStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DialogTypeFragment :
    BaseDialogFragment<TypeDialogFragmentBinding>(TypeDialogFragmentBinding::inflate) {

    override fun definition() {
        darkModeORLight()
        with(binding) {
            textViewClose.setOnClickListener {
                dialog?.dismiss()
            }
        }
    }

    private fun darkModeORLight() {
        with(binding) {
            radioGroupType.setOnCheckedChangeListener { group, checkedId ->
                when (checkedId) {
                    R.id.radioBtn_lt -> {
                        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
                            PreferencesDataStoreStatus.status(requireContext(), false)
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            dialog?.dismiss()
                        }
                    }
                    R.id.radioBtn_dt -> {
                        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
                            PreferencesDataStoreStatus.status(requireContext(), true)
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            dialog?.dismiss()
                        }
                    }
                }
            }
        }
    }
}