package com.adelivery.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adelivery.domain.entity.DeliveryCompanyEntity

@Entity(tableName = "deliverycompanyroomentity")
data class DeliveryCompanyRoomEntity(
    @PrimaryKey val id: String,
    val name: String,
    val tel: String
)

fun DeliveryCompanyRoomEntity.toEntity() =
    DeliveryCompanyEntity(
        id = id,
        name = name,
        tel = tel
    )