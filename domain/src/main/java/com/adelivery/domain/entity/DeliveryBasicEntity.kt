package com.adelivery.domain.entity

data class DeliveryBasicEntity(
    val trackId: Int,
    val delivery: DeliveryBasic
) {
    data class DeliveryBasic(
        val from: From,
        val to: TO,
        val state: State
    )
}