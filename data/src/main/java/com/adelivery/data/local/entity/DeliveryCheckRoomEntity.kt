package com.adelivery.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adelivery.domain.entity.DeliveryCheckEntity

@Entity(tableName = "deliverycheckroomentity")
data class DeliveryCheckRoomEntity(
    @PrimaryKey val trackId: String,
    val carrierId: String,
    @Embedded val from: CheckFrom,
    @Embedded val to: CheckTO,
    @Embedded val state: CheckState,
    val progressList: List<CheckProgresses>
){
    data class CheckFrom(
        val fromTime: String,
        val fromName: String
    )

    data class CheckTO(
        val toTime: String?,
        val toName: String
    )

    data class CheckState(
        val stateId: String,
        val stateText: String
    )

    data class CheckLocation(
        val locationName: String
    )

    data class CheckProgresses(
        @Embedded val progressState: CheckState,
        val progressTime: String,
        @Embedded val progressLocation: CheckLocation,
        val progressDescription: String
    )
}

fun DeliveryCheckRoomEntity.toCheckEntity() =
    DeliveryCheckEntity(
        trackId = trackId,
        carrierId = carrierId,
        from = from.toEntity(),
        state = state.toEntity(),
        to = to.toEntity(),
        progressList = progressList.map { it.toEntity() }
    )


fun DeliveryCheckRoomEntity.CheckFrom.toEntity() =
    com.adelivery.domain.entity.From(
        fromTime = fromTime,
        fromName = fromName
    )

fun DeliveryCheckRoomEntity.CheckTO.toEntity() =
    com.adelivery.domain.entity.TO(
        toTime = toTime,
        toName = toName
    )

fun DeliveryCheckRoomEntity.CheckState.toEntity() =
    com.adelivery.domain.entity.State(
        stateId = stateId,
        stateText = stateText
    )

fun DeliveryCheckRoomEntity.CheckLocation.toEntity() =
    com.adelivery.domain.entity.Location(
        locationName = locationName
    )

fun DeliveryCheckRoomEntity.CheckProgresses.toEntity() =
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
        from = from.toCheckEntity(),
        state = state.toCheckEntity(),
        to = to.toCheckEntity(),
        progressList = progressList.map { it.toEntity() }
    )


fun com.adelivery.domain.entity.From.toCheckEntity() =
    DeliveryCheckRoomEntity.CheckFrom(
        fromTime = fromTime,
        fromName = fromName
    )

fun com.adelivery.domain.entity.TO.toCheckEntity() =
    DeliveryCheckRoomEntity.CheckTO(
        toTime = toTime,
        toName = toName
    )

fun com.adelivery.domain.entity.State.toCheckEntity() =
    DeliveryCheckRoomEntity.CheckState(
        stateId = stateId,
        stateText = stateText
    )

fun com.adelivery.domain.entity.Location.toEntity() =
    DeliveryCheckRoomEntity.CheckLocation(
        locationName = locationName
    )

fun com.adelivery.domain.entity.Progresses.toEntity() =
    DeliveryCheckRoomEntity.CheckProgresses(
        progressState = progressState.toCheckEntity(),
        progressTime = progressTime,
        progressDescription = progressDescription,
        progressLocation = progressLocation.toEntity()
    )