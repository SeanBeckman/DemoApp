package com.example.demoapp.ui.utils

import io.reactivex.Single
import io.reactivex.disposables.Disposable

fun<T> Single<T>.subscribeWithErrorHandling(success: (value: T) -> Unit, failure: () -> Unit): Disposable {
    return subscribe({
        success.invoke(it)
    }, {
        failure.invoke()
    })
}