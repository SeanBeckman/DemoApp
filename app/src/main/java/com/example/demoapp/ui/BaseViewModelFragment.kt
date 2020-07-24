package com.example.demoapp.ui

import androidx.fragment.app.Fragment

abstract class BaseViewModelFragment<T>: Fragment() {

    abstract val viewModel: BaseViewModel<T>

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clear()
    }
}