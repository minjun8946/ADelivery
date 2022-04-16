package com.adelivery.data.remote.response

import com.google.gson.annotations.SerializedName

data class PatchDeliveryCheckResponse(
    @SerializedName("from") val from: From,
    @SerializedName("to") val to: TO,
    @SerializedName("state") val state: State,
    @SerializedName("progress") val progressList: List<Progresses>
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
        @SerializedName("state") val state: State,
        @SerializedName("time") val time: String,
        @SerializedName("location") val location: Location,
        @SerializedName("description") val description: String
    )
}
