package com.adelivery.data.local.datasource

import androidx.room.Insert
import com.adelivery.data.local.dao.DeliveryDao
import com.adelivery.data.local.entity.DeliveryCheckRoomEntity
import com.adelivery.data.local.entity.DeliveryCompanyRoomEntity
import javax.inject.Inject

class LocalDeliveryDataSourceImpl @Inject constructor(
    private val deliveryDao: DeliveryDao
): LocalDeliveryDataSource {
    override suspend fun insertDeliveryCheck(deliveryCheckRoomEntity: DeliveryCheckRoomEntity) =
        deliveryDao.insertDeliveryCheck(deliveryCheckRoomEntity)

    override suspend fun insertDeliveryCompany(deliveryCompanyRoomEntity: DeliveryCompanyRoomEntity) =
        deliveryDao.insertDeliveryCompany(deliveryCompanyRoomEntity)

    override suspend fun fetchDeliveryCheck(): DeliveryCheckRoomEntity =
        deliveryDao.fetchDeliveryCheck()

    override suspend fun fetchDeliveryCompany(): DeliveryCompanyRoomEntity =
        deliveryDao.fetchDeliveryCompany()
}