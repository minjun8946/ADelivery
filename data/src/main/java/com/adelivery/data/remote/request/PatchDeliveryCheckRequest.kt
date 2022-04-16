package com.adelivery.data.remote.request

data class PatchDeliveryCheckRequest(
    val carrierId: String,
    val trackId: Int
)
