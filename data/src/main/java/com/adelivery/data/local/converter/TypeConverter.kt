package com.adelivery.data.local.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.adelivery.data.local.entity.DeliveryCheckRoomEntity
import com.adelivery.data.local.entity.DeliveryCompanyRoomEntity
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

@ProvidedTypeConverter
class DeliveryCompanyConverter(
    private val moshi: Moshi
) {
    @TypeConverter
    fun fromString(value: String): List<DeliveryCompanyRoomEntity.DeliveryCompany>? {
        val listType = Types.newParameterizedType(
            List::class.java,
            DeliveryCompanyRoomEntity.DeliveryCompany::class.java
        )
        val adapter: JsonAdapter<List<DeliveryCompanyRoomEntity.DeliveryCompany>> =
            moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromList(value: List<DeliveryCompanyRoomEntity.DeliveryCompany>): String {
        val listType = Types.newParameterizedType(
            List::class.java,
            DeliveryCompanyRoomEntity.DeliveryCompany::class.java
        )
        val adapter: JsonAdapter<List<DeliveryCompanyRoomEntity.DeliveryCompany>> =
            moshi.adapter(listType)
        return adapter.toJson(value)
    }
}
@ProvidedTypeConverter
class DeliveryProgressConverter(
    private val moshi: Moshi
) {
    @TypeConverter
    fun fromString(value: String): List<DeliveryCheckRoomEntity.Progresses>? {
        val listType = Types.newParameterizedType(
            List::class.java,
            DeliveryCheckRoomEntity.Progresses::class.java
        )
        val adapter: JsonAdapter<List<DeliveryCheckRoomEntity.Progresses>> =
            moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromProgress(value: List<DeliveryCheckRoomEntity.Progresses>): String {
        val listType = Types.newParameterizedType(
            List::class.java,
            DeliveryCheckRoomEntity.Progresses::class.java
        )
        val adapter: JsonAdapter<List<DeliveryCheckRoomEntity.Progresses>> = moshi.adapter(listType)
        return adapter.toJson(value)
    }
}
