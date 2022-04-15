package com.adelivery.domain.base

interface ErrorHandler {
    suspend operator fun<T> invoke(p: suspend () -> T): T
}