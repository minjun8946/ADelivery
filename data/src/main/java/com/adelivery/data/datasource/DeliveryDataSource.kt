package com.adelivery.data.datasource

import com.adelivery.data.request.PatchDeliveryCheckRequest
import com.adelivery.data.response.FetchDeliveryCompanyResponse
import com.adelivery.data.response.PatchDeliveryCheckResponse

interface DeliveryDataSource {
    fun fetchDeliveryCompany(): FetchDeliveryCompanyResponse

    fun patchDeliveryCheck(fetchDeliveryCheckRequest: PatchDeliveryCheckRequest): PatchDeliveryCheckResponse
}