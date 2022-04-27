package com.adelivery.data.remote.response

import com.adelivery.domain.entity.DeliveryCompanyEntity
import com.google.gson.annotations.SerializedName

data class DeliveryCompanyResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("tel") val tel: String?
)

fun DeliveryCompanyResponse.toEntity() =
    DeliveryCompanyEntity(
        id = id,
        name = name,
        tel = tel
    )

