package com.adelivery.data.local.datasource

import com.adelivery.data.local.entity.DeliveryCheckRoomEntity
import com.adelivery.data.local.entity.DeliveryCompanyRoomEntity
import com.adelivery.data.remote.request.DeliveryCheckRequest
import com.adelivery.domain.entity.DeliveryCheckEntity
import com.adelivery.domain.entity.DeliveryCompanyEntity

interface LocalDeliveryDataSource {
    suspend fun insertDeliveryCheck(deliveryCheckRoomEntity: DeliveryCheckRoomEntity)

    suspend fun insertDeliveryCompany(deliveryCompanyRoomEntity: List<DeliveryCompanyRoomEntity>)

    suspend fun fetchDeliveryCheck(deliveryCheckRequest: DeliveryCheckRequest): DeliveryCheckEntity

    suspend fun fetchDeliveryList(): List<DeliveryCheckEntity>

    suspend fun fetchDeliveryCompany(): List<DeliveryCompanyEntity>
}