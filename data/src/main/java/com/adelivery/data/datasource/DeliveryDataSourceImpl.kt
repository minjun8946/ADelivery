package com.adelivery.data.datasource

import com.adelivery.data.api.DeliveryApi
import com.adelivery.data.request.PatchDeliveryCheckRequest
import com.adelivery.data.response.FetchDeliveryCompanyResponse
import com.adelivery.data.response.PatchDeliveryCheckResponse

class DeliveryDataSourceImpl(
    private val deliveryApi: DeliveryApi
): DeliveryDataSource {

    override fun fetchDeliveryCompany(): FetchDeliveryCompanyResponse =
        deliveryApi.fetchDeliveryCompany()

    override fun patchDeliveryCheck(fetchDeliveryCheckRequest: PatchDeliveryCheckRequest): PatchDeliveryCheckResponse =
        deliveryApi.patchDeliveryCheck(fetchDeliveryCheckRequest.carrierId, fetchDeliveryCheckRequest.trackId)
}