package com.adelivery.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adelivery.domain.entity.DeliveryBasicEntity
import com.adelivery.domain.entity.DeliveryCheckEntity

@Entity(tableName = "deliverybasicroomentity")
data class DeliveryBasicRoomEntity(
    @PrimaryKey(autoGenerate = true) val basicTrackId: Int,
    @Embedded val deliveryBasic: DeliveryBasic
) {
    data class DeliveryBasic(
        @Embedded val from: BasicFrom,
        @Embedded val to: BasicTO,
        @Embedded val state: BasicState
    )
    data class BasicFrom(
        val fromTime: String,
        val fromName: String
    )

    data class BasicTO(
        val toTime: String,
        val toName: String
    )

    data class BasicState(
        val stateId: String,
        val stateText: String
    )
}

fun DeliveryBasicRoomEntity.toBasicEntity() =
    DeliveryBasicEntity(
        trackId = basicTrackId,
        deliveryBasic.toEntity()
    )

fun DeliveryBasicRoomEntity.DeliveryBasic.toEntity()=
    DeliveryBasicEntity.DeliveryBasic(
        from = from.toEntity(),
        to = to.toEntity(),
        state = state.toEntity()
    )

fun DeliveryCheckEntity.toBasicRoomEntity() =
    DeliveryBasicRoomEntity(
        basicTrackId = trackId,
        deliveryBasic = DeliveryBasicRoomEntity.DeliveryBasic(
            from = from.toBasicEntity(),
            to = to.toBasicEntity(),
            state = state.toBasicEntity()
        )
    )


fun DeliveryBasicRoomEntity.BasicFrom.toEntity() =
    com.adelivery.domain.entity.From(
        fromTime = fromTime,
        fromName = fromName
    )

fun DeliveryBasicRoomEntity.BasicTO.toEntity() =
    com.adelivery.domain.entity.TO(
        toTime = toTime,
        toName = toName
    )

fun DeliveryBasicRoomEntity.BasicState.toEntity() =
    com.adelivery.domain.entity.State(
        stateId = stateId,
        stateText = stateText
    )

fun com.adelivery.domain.entity.From.toBasicEntity() =
    DeliveryBasicRoomEntity.BasicFrom(
        fromTime = fromTime,
        fromName = fromName
    )

fun com.adelivery.domain.entity.TO.toBasicEntity() =
    DeliveryBasicRoomEntity.BasicTO(
        toTime = toTime,
        toName = toName
    )

fun com.adelivery.domain.entity.State.toBasicEntity() =
    DeliveryBasicRoomEntity.BasicState(
        stateId = stateId,
        stateText = stateText
    )

