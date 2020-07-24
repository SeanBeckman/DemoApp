package com.example.demoapp.ui.bindingAdapters

import android.view.View
import androidx.databinding.BindingAdapter
import com.example.demoapp.ui.ViewState

@BindingAdapter("visibleIfHasData")
fun View.visibleIfHasData(viewState: ViewState) {
    visibility = when (viewState) {
        ViewState.HasData -> View.VISIBLE
        else -> View.GONE
    }
}

@BindingAdapter("visibleIfIsLoading")
fun View.visibleIfIsLoading(viewState: ViewState) {
    visibility = when (viewState) {
        ViewState.IsLoading -> View.VISIBLE
        else -> View.GONE
    }
}

@BindingAdapter("visibleIfHasError")
fun View.visibleIfHasError(viewState: ViewState) {
    visibility = when (viewState) {
        ViewState.HasError -> View.VISIBLE
        else -> View.GONE
    }
}