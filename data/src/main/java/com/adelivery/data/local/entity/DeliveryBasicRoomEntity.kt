package com.adelivery.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adelivery.domain.entity.DeliveryBasicEntity
import com.adelivery.domain.entity.DeliveryCheckEntity

@Entity(tableName = "deliverybasicroomentity")
data class DeliveryBasicRoomEntity(
    @PrimaryKey(autoGenerate = true) val trackId: Int,
    @Embedded val deliveryBasic: DeliveryBasic
) {
    data class DeliveryBasic(
        @Embedded val from: From,
        @Embedded val to: TO,
        @Embedded val state: State
    )
}

fun DeliveryBasicRoomEntity.toBasicEntity() =
    DeliveryBasicEntity(
        trackId = trackId,
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
        trackId = trackId,
        deliveryBasic = DeliveryBasicRoomEntity.DeliveryBasic(
            from = from.toEntity(),
            to = to.toEntity(),
            state = state.toEntity()
        )
    )

