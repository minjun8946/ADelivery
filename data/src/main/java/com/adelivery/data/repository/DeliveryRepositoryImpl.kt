package com.adelivery.data.repository

import com.adelivery.data.base.CacheUtil
import com.adelivery.data.local.datasource.LocalDeliveryDataSource
import com.adelivery.data.local.entity.*
import com.adelivery.data.remote.datasource.RemoteDeliveryDataSource
import com.adelivery.data.remote.request.toEntity
import com.adelivery.domain.base.CacheType
import com.adelivery.domain.entity.DeliveryBasicEntity
import com.adelivery.domain.entity.DeliveryCheckEntity
import com.adelivery.domain.entity.DeliveryCompanyEntity
import com.adelivery.domain.param.DeliveryCheckParam
import com.adelivery.domain.repository.DeliveryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DeliveryRepositoryImpl(
    private val remoteDeliveryDataSource: RemoteDeliveryDataSource,
    private val localDeliveryDataSource: LocalDeliveryDataSource
): DeliveryRepository {

    override suspend fun fetchDeliveryBasic():Flow<List<DeliveryBasicEntity>> =
        flow { localDeliveryDataSource.fetchDeliveryBasic() }

    override suspend fun fetchDeliveryCheck(deliveryCheckParam: DeliveryCheckParam): Flow<DeliveryCheckEntity> =
        CacheUtil<DeliveryCheckEntity>()
            .localDataSource { localDeliveryDataSource.fetchDeliveryCheck(deliveryCheckParam.toEntity()) }
            .remoteDataSource { remoteDeliveryDataSource.patchDeliveryCheck(deliveryCheckParam.toEntity()) }
            .insertRoom { localDeliveryDataSource.insertDeliveryCheck(it.toCheckRoomEntity()) }
            .insertRoom { localDeliveryDataSource.insertDeliveryBasic(it.toBasicRoomEntity()) }
            .cacheType(CacheType(CacheType = CacheType.Type.ALWAYS))

    override suspend fun fetchDeliveryCompany(): Flow<List<DeliveryCompanyEntity>> =
        CacheUtil<List<DeliveryCompanyEntity>>()
            .localDataSource { localDeliveryDataSource.fetchDeliveryCompany() }
            .remoteDataSource { remoteDeliveryDataSource.fetchDeliveryCompany() }
            .insertRoom { localDeliveryDataSource.insertDeliveryCompany(it.map { it.toEntity() }) }
            .cacheType(CacheType((CacheType.Type.ONES)))
}