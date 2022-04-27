package com.adelivery.data.remote.request

import com.adelivery.domain.param.DeliveryCheckParam

data class DeliveryCheckRequest(
    val carrierId: String,
    val trackId: String
)

fun DeliveryCheckParam.toEntity() =
    DeliveryCheckRequest(
        carrierId = carrierId,
        trackId = trackId
    )
