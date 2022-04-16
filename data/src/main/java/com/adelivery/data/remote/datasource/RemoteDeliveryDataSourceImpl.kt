package com.adelivery.data.remote.datasource

import com.adelivery.data.remote.api.DeliveryApi
import com.adelivery.data.remote.request.PatchDeliveryCheckRequest
import com.adelivery.data.remote.response.FetchDeliveryCompanyResponse
import com.adelivery.data.remote.response.PatchDeliveryCheckResponse
import com.adelivery.domain.base.ErrorHandler
import javax.inject.Inject

class RemoteDeliveryDataSourceImpl @Inject constructor(
    private val deliveryApi: DeliveryApi,
    private val errorHandler: ErrorHandler
): RemoteDeliveryDataSource {

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