package com.adelivery.data.remote.datasource

import com.adelivery.data.remote.request.PatchDeliveryCheckRequest
import com.adelivery.data.remote.response.FetchDeliveryCompanyResponse
import com.adelivery.data.remote.response.PatchDeliveryCheckResponse

interface RemoteDeliveryDataSource {
    suspend fun fetchDeliveryCompany(): FetchDeliveryCompanyResponse

    suspend fun patchDeliveryCheck(fetchDeliveryCheckRequest: PatchDeliveryCheckRequest): PatchDeliveryCheckResponse
}