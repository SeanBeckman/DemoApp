package com.example.demoapp.domain

import io.reactivex.Single

abstract class BaseGetUseCase<T> {
    abstract fun execute(): Single<UseCaseResult<T>>
}