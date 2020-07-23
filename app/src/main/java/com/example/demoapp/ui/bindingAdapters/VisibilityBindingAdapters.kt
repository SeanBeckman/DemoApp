package com.example.demoapp.ui.bindingAdapters

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("isVisible")
fun View.isVisible(boolean: Boolean) {
    visibility = if (boolean) View.VISIBLE else View.GONE
}