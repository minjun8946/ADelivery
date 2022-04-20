package com.adelivery.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adelivery.domain.entity.DeliveryCheckEntity

@Entity(tableName = "deliverycheckroomentity")
data class DeliveryCheckRoomEntity(
    @PrimaryKey(autoGenerate = true) val trackId: Int,
    val carrierId: String,
    @Embedded val from: From,
    @Embedded val to: TO,
    @Embedded val state: State,
    val progressList: List<Progresses>
)

data class From(
    val fromTime: String,
    val fromName: String
)

data class TO(
    val toTime: String,
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
    @Embedded val progressState: State,
    val progressTime: String,
    @Embedded val progressLocation: Location,
    val progressDescription: String
)

fun DeliveryCheckRoomEntity.toCheckEntity() =
    DeliveryCheckEntity(
        trackId = trackId,
        carrierId = carrierId,
        from = from.toEntity(),
        state = state.toEntity(),
        to = to.toEntity(),
        progressList = progressList.map { it.toEntity() }
    )


fun From.toEntity() =
    com.adelivery.domain.entity.From(
        fromTime = fromTime,
        fromName = fromName
    )

fun TO.toEntity() =
    com.adelivery.domain.entity.TO(
        toTime = toTime,
        toName = toName
    )

fun State.toEntity() =
    com.adelivery.domain.entity.State(
        stateId = stateId,
        stateText = stateText
    )

fun Location.toEntity() =
    com.adelivery.domain.entity.Location(
        locationName = locationName
    )

fun Progresses.toEntity() =
    com.adelivery.domain.entity.Progresses(
        progressState = progressState.toEntity(),
        progressTime = progressTime,
        progressDescription = progressDescription,
        progressLocation = progressLocation.toEntity()
    )

fun DeliveryCheckEntity.toCheckRoomEntity() =
    DeliveryCheckRoomEntity(
        trackId = trackId,
        carrierId = carrierId,
        from = from.toEntity(),
        state = state.toEntity(),
        to = to.toEntity(),
        progressList = progressList.map { it.toEntity() }
    )


fun com.adelivery.domain.entity.From.toEntity() =
    From(
        fromTime = fromTime,
        fromName = fromName
    )

fun com.adelivery.domain.entity.TO.toEntity() =
    TO(
        toTime = toTime,
        toName = toName
    )

fun com.adelivery.domain.entity.State.toEntity() =
    State(
        stateId = stateId,
        stateText = stateText
    )

fun com.adelivery.domain.entity.Location.toEntity() =
    Location(
        locationName = locationName
    )

fun com.adelivery.domain.entity.Progresses.toEntity() =
    Progresses(
        progressState = progressState.toEntity(),
        progressTime = progressTime,
        progressDescription = progressDescription,
        progressLocation = progressLocation.toEntity()
    )