package com.adelivery.domain.base

class UnknownError(msg: String) : RuntimeException()
class NoInternetError(): RuntimeException()
class NotFound(val msg: String) : RuntimeException()
class TooManyRequest(val msg: String): RuntimeException()
class BadRequest(val msg: String): RuntimeException()
class BadGateWay(val msg: String): RuntimeException()
class ServerError(val msg: String): RuntimeException()