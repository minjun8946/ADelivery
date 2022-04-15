package com.adelivery.data.base

import com.adelivery.domain.base.ErrorHandler
import com.adelivery.domain.base.NotFound
import com.adelivery.domain.base.Unknown
import retrofit2.HttpException
import javax.inject.Inject


class ErrorHandlerImpl @Inject constructor() : ErrorHandler {

    override suspend fun <T> invoke(p: suspend () -> T): T {
        return try {
            p.invoke()
        } catch (e: Throwable) {
            throw if (e !is HttpException) {
                Unknown()
            } else {
                when (e.code()) {
                    404 -> NotFound()
                    else -> Unknown()
                }
            }
        }
    }
}