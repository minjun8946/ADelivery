package com.adelivery.data.remote.request

import com.adelivery.domain.param.DeliveryCheckParam

data class DeliveryCheckRequest(
    val carrierId: String,
    val trackId: Int
)

fun DeliveryCheckParam.toEntity() =
    DeliveryCheckRequest(
        carrierId = carrierId,
        trackId = trackId
    )
