package com.adelivery.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deliverycheckroomentity")
data class DeliveryCheckRoomEntity(
    @PrimaryKey(autoGenerate = true) val trackId: Int,
    val carrierId: String,
    @Embedded val from: From,
    @Embedded val to: TO,
    @Embedded val state: State,
    val progressList: List<Progresses>
) {
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
}