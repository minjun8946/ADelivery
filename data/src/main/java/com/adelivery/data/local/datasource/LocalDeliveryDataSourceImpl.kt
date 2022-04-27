package com.adelivery.data.local.datasource

import com.adelivery.data.local.dao.DeliveryDao
import com.adelivery.data.local.entity.*
import com.adelivery.data.remote.request.DeliveryCheckRequest
import com.adelivery.domain.entity.DeliveryCheckEntity
import com.adelivery.domain.entity.DeliveryCompanyEntity
import javax.inject.Inject

class LocalDeliveryDataSourceImpl @Inject constructor(
    private val deliveryDao: DeliveryDao
): LocalDeliveryDataSource {
    override suspend fun insertDeliveryCheck(deliveryCheckRoomEntity: DeliveryCheckRoomEntity) =
        deliveryDao.insertDeliveryCheck(deliveryCheckRoomEntity)

    override suspend fun insertDeliveryCompany(deliveryCompanyRoomEntity: List<DeliveryCompanyRoomEntity>) =
        deliveryDao.insertDeliveryCompany(deliveryCompanyRoomEntity)


    override suspend fun fetchDeliveryCheck(deliveryCheckRequest: DeliveryCheckRequest): DeliveryCheckEntity =
        deliveryDao.fetchDeliveryCheck(deliveryCheckRequest.trackId).toCheckEntity()

    override suspend fun fetchDeliveryList(): List<DeliveryCheckEntity> =
        deliveryDao.fetchDeliveryList().map { it.toCheckEntity() }


    override suspend fun fetchDeliveryCompany(): List<DeliveryCompanyEntity> =
        deliveryDao.fetchDeliveryCompany().map { it.toEntity() }
}