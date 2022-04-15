package com.adelivery.data.datasource

import com.adelivery.data.api.DeliveryApi
import com.adelivery.data.request.PatchDeliveryCheckRequest
import com.adelivery.data.response.FetchDeliveryCompanyResponse
import com.adelivery.data.response.PatchDeliveryCheckResponse
import com.adelivery.domain.base.ErrorHandler

class DeliveryDataSourceImpl(
    private val deliveryApi: DeliveryApi,
    private val errorHandler: ErrorHandler
): DeliveryDataSource {

    override suspend fun fetchDeliveryCompany(): FetchDeliveryCompanyResponse =
        errorHandler { deliveryApi.fetchDeliveryCompany() }


    override suspend fun patchDeliveryCheck(
        fetchDeliveryCheckRequest: PatchDeliveryCheckRequest
    ): PatchDeliveryCheckResponse =
        errorHandler {
            deliveryApi.patchDeliveryCheck(
                fetchDeliveryCheckRequest.carrierId,
                fetchDeliveryCheckRequest.trackId
            )
        }
}