package com.adelivery.domain.repository

import com.adelivery.domain.entity.DeliveryCheckEntity
import com.adelivery.domain.entity.DeliveryCompanyEntity
import com.adelivery.domain.param.DeliveryCheckParam
import kotlinx.coroutines.flow.Flow

interface DeliveryRepository {

    suspend fun fetchDeliveryCheck(deliveryCheckParam: DeliveryCheckParam): Flow<DeliveryCheckEntity>

    suspend fun fetchDeliveryList(): Flow<List<DeliveryCheckEntity>>

    suspend fun fetchDeliveryCompany(): Flow<List<DeliveryCompanyEntity>>
}