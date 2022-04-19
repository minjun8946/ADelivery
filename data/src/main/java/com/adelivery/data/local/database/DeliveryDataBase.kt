package com.adelivery.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.adelivery.data.local.converter.DeliveryProgressConverter
import com.adelivery.data.local.dao.*
import com.adelivery.data.local.entity.DeliveryBasicRoomEntity
import com.adelivery.data.local.entity.DeliveryCheckRoomEntity
import com.adelivery.data.local.entity.DeliveryCompanyRoomEntity

@Database(
    entities = [
        DeliveryCheckRoomEntity::class,
        DeliveryCompanyRoomEntity::class,
        DeliveryBasicRoomEntity::class
    ], version = 1, exportSchema = false
)

@TypeConverters(
    value = [
        DeliveryProgressConverter::class
    ]
)

abstract class DeliveryDataBase: RoomDatabase() {
    abstract fun deliveryDao(): DeliveryDao
}