package com.adelivery.data.request

data class PatchDeliveryCheckRequest(
    val carrierId: String,
    val trackId: Int
)
