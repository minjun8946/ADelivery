package com.adelivery.data.local.datasource

import com.adelivery.data.local.dao.DeliveryDao
import com.adelivery.data.local.entity.DeliveryBasicRoomEntity
import com.adelivery.data.local.entity.DeliveryCheckRoomEntity
import com.adelivery.data.local.entity.DeliveryCompanyRoomEntity
import com.adelivery.data.local.entity.toEntity
import com.adelivery.data.remote.request.DeliveryCheckRequest
import com.adelivery.domain.entity.DeliveryBasicEntity
import com.adelivery.domain.entity.DeliveryCheckEntity
import com.adelivery.domain.entity.DeliveryCompanyEntity
import javax.inject.Inject

class LocalDeliveryDataSourceImpl @Inject constructor(
    private val deliveryDao: DeliveryDao
): LocalDeliveryDataSource {
    override suspend fun insertDeliveryCheck(deliveryCheckRoomEntity: DeliveryCheckRoomEntity) =
        deliveryDao.insertDeliveryCheck(deliveryCheckRoomEntity)

    override suspend fun insertDeliveryCompany(deliveryCompanyRoomEntity: DeliveryCompanyRoomEntity) =
        deliveryDao.insertDeliveryCompany(deliveryCompanyRoomEntity)

    override suspend fun insertDeliveryBasic(deliveryBasicRoomEntity: DeliveryBasicRoomEntity) =
        deliveryDao.insertDeliveryBasicRoom(deliveryBasicRoomEntity)


    override suspend fun fetchDeliveryBasic(): List<DeliveryBasicEntity> =
        deliveryDao.fetchDeliveryBasic().map { it.toEntity() }


    override suspend fun fetchDeliveryCheck(deliveryCheckRequest: DeliveryCheckRequest): DeliveryCheckEntity =
        deliveryDao.fetchDeliveryCheck(deliveryCheckRequest.trackId).toEntity()

    override suspend fun fetchDeliveryCompany(): List<DeliveryCompanyEntity> =
        deliveryDao.fetchDeliveryCompany().map { it.toEntity() }
}