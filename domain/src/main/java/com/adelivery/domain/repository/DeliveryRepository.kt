package com.adelivery.domain.repository

import com.adelivery.domain.entity.DeliveryBasicEntity
import com.adelivery.domain.entity.DeliveryCheckEntity
import com.adelivery.domain.entity.DeliveryCompanyEntity
import com.adelivery.domain.param.DeliveryCheckParam
import kotlinx.coroutines.flow.Flow

interface DeliveryRepository {
    suspend fun fetchDeliveryBasic(): Flow<List<DeliveryBasicEntity>>

    suspend fun fetchDeliveryCheck(deliveryCheckParam: DeliveryCheckParam): Flow<DeliveryCheckEntity>

    suspend fun fetchDeliveryCompany(): Flow<List<DeliveryCompanyEntity>>
}