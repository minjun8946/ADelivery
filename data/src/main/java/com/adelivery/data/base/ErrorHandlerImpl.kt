package com.adelivery.data.base

import com.adelivery.domain.base.*
import retrofit2.HttpException
import java.net.UnknownHostException
import javax.inject.Inject

class ErrorHandlerImpl @Inject constructor() : ErrorHandler {

    override suspend fun <T> invoke(p: suspend () -> T): T {
        return try {
            p.invoke()
        } catch (e: Throwable) {
            throw if (e !is HttpException) {
                UnknownError(msg = e.message?: "no message")
            } else {
                when (e.code()) {
                    400 -> BadRequest(e.message())
                    429 -> TooManyRequest(e.message())
                    404 -> NotFound(e.message())
                    500 -> ServerError(e.message())
                    502 -> BadGateWay(e.message())
                    else -> UnknownError()
                }
            }
        } catch (e: UnknownHostException){
            throw NoInternetError()
        }
    }
}