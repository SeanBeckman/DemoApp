package com.example.demoapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoapp.domain.BaseGetUseCase
import com.example.demoapp.domain.UseCaseError
import com.example.demoapp.domain.UseCaseResult
import com.example.demoapp.domain.UseCaseSuccess
import com.example.demoapp.ui.utils.subscribeWithErrorHandling
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<T>: ViewModel() {
    val compositeDisposable = CompositeDisposable()

    private val _state = MutableLiveData<ViewState>()
    val state: LiveData<ViewState> = _state

    fun processUseCase(useCase: BaseGetUseCase<T>) {
        _state.value = ViewState.IsLoading

        val disposable = useCase
            .execute()
            .subscribeWithErrorHandling(this::processResult, this::changeStateForError)
        compositeDisposable.add(disposable)
    }

    private fun processResult(result: UseCaseResult<T>) {
        when (result) {
            is UseCaseSuccess -> changeStateForSuccess(result.value)
            is UseCaseError -> changeStateForError()
        }
    }

    private fun changeStateForSuccess(result: T) {
        _state.value = ViewState.HasData
        processSuccess(result)
    }

    abstract fun processSuccess(result: T)

    private fun changeStateForError() {
        _state.value = ViewState.HasError
        processError()
    }

    abstract fun processError()

    fun clear() {
        compositeDisposable.clear()
    }
}