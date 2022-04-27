package com.adelivery.adelivery.base

import com.adelivery.data.base.ErrorHandlerImpl
import com.adelivery.domain.base.ErrorHandler
import com.adelivery.domain.base.UnknownError
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers

val exceptionHandler = CoroutineExceptionHandler{ a, error ->

    println("errorss ${error} $a")
}