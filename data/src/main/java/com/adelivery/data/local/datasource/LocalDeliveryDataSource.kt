package com.adelivery.data.local.datasource

import com.adelivery.data.local.entity.DeliveryCheckRoomEntity
import com.adelivery.data.local.entity.DeliveryCompanyRoomEntity

interface LocalDeliveryDataSource {
    suspend fun insertDeliveryCheck(deliveryCheckRoomEntity: DeliveryCheckRoomEntity)

    suspend fun insertDeliveryCompany(deliveryCompanyRoomEntity: DeliveryCompanyRoomEntity)

    suspend fun fetchDeliveryCheck(): DeliveryCheckRoomEntity

    suspend fun fetchDeliveryCompany(): DeliveryCompanyRoomEntity
}