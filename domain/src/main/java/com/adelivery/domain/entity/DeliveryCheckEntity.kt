package com.adelivery.domain.entity

data class DeliveryCheckEntity(
    val trackId: String,
    val carrierId: String,
    val from: From,
    val to: TO,
    val state: State,
    val progressList: List<Progresses>
)

data class From(
    val fromTime: String,
    val fromName: String
)

data class TO(
    val toTime: String?,
    val toName: String
)

data class State(
    val stateId: String,
    val stateText: String
)

data class Location(
    val locationName: String
)

data class Progresses(
    val progressState: State,
    val progressTime: String,
    val progressLocation: Location,
    val progressDescription: String
)