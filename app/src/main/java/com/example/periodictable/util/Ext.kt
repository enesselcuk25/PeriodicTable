package com.example.periodictable.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.annotation.DimenRes
import androidx.databinding.BindingAdapter
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.periodictable.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

object Ext {
    @JvmStatic
    @BindingAdapter("app:loadImage")
    fun ImageView.loadImage(url: String) {
        Glide.with(this)
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .error(R.drawable.question_icon)
            .into(this)
    }

    fun <T> LifecycleOwner.collectLatest(flow: Flow<T>, actionsUiState: suspend (T) -> Unit) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    flow.collectLatest(actionsUiState)
                }
            }
        }
    }

    fun <T> LifecycleOwner.collect(flow: Flow<T>, actionsUiState: suspend (T) -> Unit) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    flow.collect {
                        actionsUiState.invoke(it)
                    }
                }
            }
        }
    }

    @BindingAdapter("app:progress")
    fun ProgressBar.progressBar(visible: Boolean) {
        this.visibility = if (visible) View.VISIBLE else View.GONE
    }


}