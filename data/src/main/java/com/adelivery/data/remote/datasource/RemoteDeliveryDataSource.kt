package com.adelivery.data.remote.datasource

import com.adelivery.data.remote.request.DeliveryCheckRequest
import com.adelivery.domain.entity.DeliveryCheckEntity
import com.adelivery.domain.entity.DeliveryCompanyEntity

interface RemoteDeliveryDataSource {
    suspend fun fetchDeliveryCompany(): List<DeliveryCompanyEntity>

    suspend fun patchDeliveryCheck(deliveryCheckRequest: DeliveryCheckRequest): DeliveryCheckEntity
}