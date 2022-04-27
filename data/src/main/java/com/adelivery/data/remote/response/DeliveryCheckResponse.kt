package com.adelivery.data.remote.response

import com.adelivery.data.remote.request.DeliveryCheckRequest
import com.adelivery.domain.entity.*
import com.google.gson.annotations.SerializedName

data class DeliveryCheckResponse(
    @SerializedName("from") val from: From,
    @SerializedName("to") val to: TO?,
    @SerializedName("state") val state: State,
    @SerializedName("progresses") val progressList: List<Progresses>,
    @SerializedName("carrier") val carrier: Carrier
) {
    data class From(
        @SerializedName("time") val time: String,
        @SerializedName("name") val name: String
    )

    data class TO(
        @SerializedName("time") val time: String,
        @SerializedName("name") val name: String
    )

    data class State(
        @SerializedName("id") val id: String,
        @SerializedName("text") val text: String
    )

    data class Location(
        @SerializedName("name") val name: String
    )

    data class Progresses(
        @SerializedName("status") val state: State,
        @SerializedName("time") val time: String,
        @SerializedName("location") val location: Location,
        @SerializedName("description") val description: String
    )
    data class Carrier(
        @SerializedName("id") val id: String,
        @SerializedName("name") val name: String,
        @SerializedName("tel") val tel: String
    )
}

fun DeliveryCheckResponse.toEntity(deliveryCheckRequest: DeliveryCheckRequest) =
    to?.let {
        DeliveryCheckEntity(
        trackId = deliveryCheckRequest.trackId,
        carrierId = deliveryCheckRequest.carrierId,
        from = from.toEntity(),
        to = it.toEntity(),
        state = state.toEntity(),
        progressList = progressList.map { it.toEntity() }
    )
    }

fun DeliveryCheckResponse.From.toEntity() =
    From(
        fromName = name,
        fromTime = time
    )

fun DeliveryCheckResponse.TO.toEntity() =
    TO(
        toName = name,
        toTime = time
    )

fun DeliveryCheckResponse.State.toEntity() =
    State(
        stateId = id,
        stateText = text
    )

fun DeliveryCheckResponse.Location.toEntity() =
    Location(
        locationName = name
    )

fun DeliveryCheckResponse.Progresses.toEntity() =
    Progresses(
        progressLocation = location.toEntity(),
        progressDescription = description,
        progressState = state.toEntity(),
        progressTime = time
    )