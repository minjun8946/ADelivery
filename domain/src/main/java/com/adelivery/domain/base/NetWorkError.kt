package com.adelivery.domain.base

class Unknown : RuntimeException()
class NotFound : RuntimeException()
class ToManyRequest: RuntimeException()
class BadRequest: RuntimeException()
class BadGateWay: RuntimeException()
class ServerError: RuntimeException()