package com.adelivery.data.remote.datasource

import com.adelivery.data.remote.api.DeliveryApi
import com.adelivery.data.remote.request.DeliveryCheckRequest
import com.adelivery.data.remote.response.toEntity
import com.adelivery.domain.base.ErrorHandler
import com.adelivery.domain.entity.DeliveryCompanyEntity
import com.adelivery.domain.entity.DeliveryCheckEntity
import javax.inject.Inject

class RemoteDeliveryDataSourceImpl @Inject constructor(
    private val deliveryApi: DeliveryApi,
    private val errorHandler: ErrorHandler
): RemoteDeliveryDataSource {

    override suspend fun fetchDeliveryCompany(): List<DeliveryCompanyEntity> =
        errorHandler { deliveryApi.fetchDeliveryCompany().map { it.toEntity() } }


    override suspend fun patchDeliveryCheck(
        deliveryCheckRequest: DeliveryCheckRequest
    ): DeliveryCheckEntity =
        errorHandler {
            deliveryApi.patchDeliveryCheck(
                deliveryCheckRequest.carrierId,
                deliveryCheckRequest.trackId
            ).toEntity(deliveryCheckRequest)
        }
}