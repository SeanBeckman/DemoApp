package com.example.demoapp.ui.bindingAdapters

import android.view.View
import androidx.databinding.BindingAdapter

class VisibilityBindingAdapters {

    companion object {
        @BindingAdapter("app:isVisible")
        fun isVisible(view: View, boolean: Boolean) {
            view.visibility = if (boolean) View.VISIBLE else View.GONE
        }
    }
}