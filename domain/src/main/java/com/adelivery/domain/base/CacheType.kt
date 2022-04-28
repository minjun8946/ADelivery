package com.adelivery.domain.base

data class CacheType(
    val CacheType: Type? = Type.ALWAYS
) {
    enum class Type {
        ALWAYS,
        NEVER,
        COMPARE,
        ONES,
        LOCAL
    }
}