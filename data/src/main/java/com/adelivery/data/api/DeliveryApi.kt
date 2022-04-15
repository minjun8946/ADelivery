package com.adelivery.data.api

import com.adelivery.data.response.FetchDeliveryCompanyResponse
import com.adelivery.data.response.PatchDeliveryCheckResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DeliveryApi{
    @GET("/")
    fun fetchDeliveryCompany(): FetchDeliveryCompanyResponse

    @GET("{carrier_id}/tracks/{track_id}")
    fun patchDeliveryCheck(
        @Path("carrier_id") carrierId: String,
        @Path("track_id") trackId: Int
    ): PatchDeliveryCheckResponse
}
