package com.adelivery.adelivery.hilt

import com.adelivery.data.remote.datasource.RemoteDeliveryDataSource
import com.adelivery.data.remote.datasource.RemoteDeliveryDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Singleton
    @Binds
    abstract fun provideRemoteSocketDataSource(
        remoteSocketDataSourceImpl: RemoteDeliveryDataSourceImpl,
    ): RemoteDeliveryDataSource
}