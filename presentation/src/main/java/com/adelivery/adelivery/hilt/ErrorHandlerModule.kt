package com.adelivery.adelivery.hilt

import com.adelivery.data.base.ErrorHandlerImpl
import com.adelivery.domain.base.ErrorHandler
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

abstract class ErrorHandlerModule {

    @Binds
    abstract fun provideErrorHandler(
        errorHandlerImpl: ErrorHandlerImpl
    ): ErrorHandler
}