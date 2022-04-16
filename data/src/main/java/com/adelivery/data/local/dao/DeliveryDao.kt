package com.adelivery.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adelivery.data.local.entity.DeliveryCheckRoomEntity
import com.adelivery.data.local.entity.DeliveryCompanyRoomEntity

@Dao
interface DeliveryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeliveryCompany(deliveryCompanyRoomEntity: DeliveryCompanyRoomEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeliveryCheck(deliveryCheckRoomEntity: DeliveryCheckRoomEntity)

    @Query("SELECT * FROM deliverycheckroomentity")
    fun fetchDeliveryCheck(): DeliveryCheckRoomEntity

    @Query("SELECT * FROM deliverycompanyroomentity")
    fun fetchDeliveryCompany(): DeliveryCompanyRoomEntity
}