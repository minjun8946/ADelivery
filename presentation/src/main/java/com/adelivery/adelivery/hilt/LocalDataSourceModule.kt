package com.adelivery.adelivery.hilt

import com.adelivery.data.local.datasource.LocalDeliveryDataSource
import com.adelivery.data.local.datasource.LocalDeliveryDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    abstract fun provideLocalBadgeDataSource(
        localDeliveryDataSourceImpl: LocalDeliveryDataSourceImpl
    ): LocalDeliveryDataSource
}