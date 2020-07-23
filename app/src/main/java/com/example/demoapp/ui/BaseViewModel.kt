package com.example.demoapp.ui

import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {
    abstract fun clear()
}