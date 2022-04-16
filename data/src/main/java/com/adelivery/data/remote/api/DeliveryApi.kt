package com.adelivery.data.remote.api

import com.adelivery.data.remote.response.FetchDeliveryCompanyResponse
import com.adelivery.data.remote.response.PatchDeliveryCheckResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DeliveryApi{
    @GET("/")
    suspend fun fetchDeliveryCompany(): FetchDeliveryCompanyResponse

    @GET("{carrier_id}/tracks/{track_id}")
    suspend fun patchDeliveryCheck(
        @Path("carrier_id") carrierId: String,
        @Path("track_id") trackId: Int
    ): PatchDeliveryCheckResponse
}
