package com.adelivery.data.local.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.adelivery.data.local.entity.DeliveryBasicRoomEntity
import com.adelivery.data.local.entity.DeliveryCheckRoomEntity
import com.adelivery.data.local.entity.DeliveryCompanyRoomEntity
import com.adelivery.data.local.entity.Progresses
import com.squareup.moshi.Json
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

@ProvidedTypeConverter
class DeliveryProgressConverter(
    private val moshi: Moshi
) {
    @TypeConverter
    fun fromString(value: String): List<Progresses>? {
        val listType = Types.newParameterizedType(
            List::class.java,
            Progresses::class.java
        )
        val adapter: JsonAdapter<List<Progresses>> =
            moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromProgress(value: List<Progresses>): String {
        val listType = Types.newParameterizedType(
            List::class.java,
            Progresses::class.java
        )
        val adapter: JsonAdapter<List<Progresses>> = moshi.adapter(listType)
        return adapter.toJson(value)
    }
}
