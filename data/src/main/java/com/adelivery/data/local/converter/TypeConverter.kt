package com.adelivery.data.local.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.adelivery.data.local.entity.DeliveryCheckRoomEntity
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

@ProvidedTypeConverter
class DeliveryProgressConverter(
    private val moshi: Moshi
) {
    @TypeConverter
    fun fromString(value: String): List<DeliveryCheckRoomEntity.CheckProgresses>? {
        val listType = Types.newParameterizedType(
            List::class.java,
            DeliveryCheckRoomEntity.CheckProgresses::class.java
        )
        val adapter: JsonAdapter<List<DeliveryCheckRoomEntity.CheckProgresses>> =
            moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromProgress(value: List<DeliveryCheckRoomEntity.CheckProgresses>): String {
        val listType = Types.newParameterizedType(
            List::class.java,
            DeliveryCheckRoomEntity.CheckProgresses::class.java
        )
        val adapter: JsonAdapter<List<DeliveryCheckRoomEntity.CheckProgresses>> = moshi.adapter(listType)
        return adapter.toJson(value)
    }
}
