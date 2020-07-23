package com.example.demoapp.domain

sealed class UseCaseResult<T>

class UseCaseSuccess<T>(val value: T): UseCaseResult<T>()
class UseCaseError<T>(val error: Throwable): UseCaseResult<T>()