package com.adelivery.adelivery.hilt

import com.adelivery.data.repository.DeliveryRepositoryImpl
import com.adelivery.domain.repository.DeliveryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun providesSocketRepository(
        socketRepositoryImpl: DeliveryRepositoryImpl
    ): DeliveryRepository
}