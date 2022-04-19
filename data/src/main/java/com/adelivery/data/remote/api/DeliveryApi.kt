package com.adelivery.data.remote.api

import com.adelivery.data.remote.response.DeliveryCompanyResponse
import com.adelivery.data.remote.response.DeliveryCheckResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DeliveryApi{
    @GET("/")
    suspend fun fetchDeliveryCompany(): List<DeliveryCompanyResponse>

    @GET("{carrier_id}/tracks/{track_id}")
    suspend fun patchDeliveryCheck(
        @Path("carrier_id") carrierId: String,
        @Path("track_id") trackId: Int
    ): DeliveryCheckResponse
}
