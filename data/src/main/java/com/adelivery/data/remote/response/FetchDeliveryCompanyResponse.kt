package com.adelivery.data.remote.response

import com.google.gson.annotations.SerializedName

data class FetchDeliveryCompanyResponse(
    val deliveryCompanyList: DeliveryCompany
) {
    data class DeliveryCompany(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("tel") val tel: String
    )
}
