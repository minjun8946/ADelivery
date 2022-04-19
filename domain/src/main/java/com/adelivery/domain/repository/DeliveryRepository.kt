package com.adelivery.domain.repository

import com.adelivery.domain.entity.DeliveryBasicEntity
import com.adelivery.domain.entity.DeliveryCheckEntity
import com.adelivery.domain.entity.DeliveryCompanyEntity
import com.adelivery.domain.param.DeliveryCheckParam

interface DeliveryRepository {
    suspend fun insertDeliveryCheck(deliveryCheckEntity: DeliveryCheckEntity)

    suspend fun insertDeliveryCompany(deliveryCompanyEntity: DeliveryCompanyEntity)

    suspend fun insertDeliveryBasic(deliveryBasicEntity: DeliveryBasicEntity)

    suspend fun fetchDeliveryBasic(): List<DeliveryBasicEntity>

    suspend fun fetchDeliveryCheck(deliveryCheckParam: DeliveryCheckParam): DeliveryCheckEntity

    suspend fun fetchDeliveryCompany(): DeliveryCompanyEntity
}