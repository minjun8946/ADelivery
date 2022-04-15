package com.adelivery.data.request

import com.google.gson.annotations.SerializedName

data class PatchDeliveryCheckRequest(
    @SerializedName("carrierId") val carrierId: Int,
    @SerializedName("trackId") val trackId: Int
)
