package com.adelivery.data.datasource

import com.adelivery.data.request.PatchDeliveryCheckRequest
import com.adelivery.data.response.FetchDeliveryCompanyResponse
import com.adelivery.data.response.PatchDeliveryCheckResponse

interface DeliveryDataSource {
    suspend fun fetchDeliveryCompany(): FetchDeliveryCompanyResponse

    suspend fun patchDeliveryCheck(fetchDeliveryCheckRequest: PatchDeliveryCheckRequest): PatchDeliveryCheckResponse
}