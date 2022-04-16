package com.adelivery.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deliverycompanyroomentity")
data class DeliveryCompanyRoomEntity(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val deliveryCompanyList: List<DeliveryCompany>
){
    data class DeliveryCompany(
        val id: String,
        val name: String,
        val tel: String
    )
}