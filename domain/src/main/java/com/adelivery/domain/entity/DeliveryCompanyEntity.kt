package com.adelivery.domain.entity

data class DeliveryCompanyEntity(
    var id: Int = 0,
    val deliveryCompanyList: List<DeliveryCompany>
){
    data class DeliveryCompany(
        val id: String,
        val name: String,
        val tel: String
    )
}