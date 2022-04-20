package com.adelivery.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adelivery.data.local.entity.DeliveryBasicRoomEntity
import com.adelivery.data.local.entity.DeliveryCheckRoomEntity
import com.adelivery.data.local.entity.DeliveryCompanyRoomEntity

@Dao
interface DeliveryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeliveryCompany(deliveryCompanyRoomEntity: List<DeliveryCompanyRoomEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeliveryCheck(deliveryCheckRoomEntity: DeliveryCheckRoomEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeliveryBasicRoom(deliveryBasicRoomEntity: DeliveryBasicRoomEntity)

    @Query("SELECT * FROM deliverycheckroomentity WHERE trackId== :trackId")
    fun fetchDeliveryCheck(trackId: Int): DeliveryCheckRoomEntity

    @Query("SELECT * FROM deliverycompanyroomentity")
    fun fetchDeliveryCompany(): List<DeliveryCompanyRoomEntity>

    @Query("SELECT *FROM deliverybasicroomentity")
    fun fetchDeliveryBasic(): List<DeliveryBasicRoomEntity>

}