package com.adelivery.adelivery.hilt

import android.content.Context
import androidx.room.Room
import com.adelivery.data.local.converter.DeliveryProgressConverter
import com.adelivery.data.local.dao.DeliveryDao
import com.adelivery.data.local.database.DeliveryDataBase
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    fun provideWalkHubDatabase(
        @ApplicationContext context: Context,
        moshi: Moshi
    ): DeliveryDataBase = Room
        .databaseBuilder(context, DeliveryDataBase::class.java, "WalkHubDataBase")
        .fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .addTypeConverter(DeliveryProgressConverter(moshi))
        .build()

    @Provides
    fun provideChallengeDao(
        walkHubDataBase: DeliveryDataBase
    ): DeliveryDao = walkHubDataBase.deliveryDao()

}