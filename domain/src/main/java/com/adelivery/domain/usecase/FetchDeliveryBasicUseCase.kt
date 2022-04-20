package com.adelivery.domain.usecase

import com.adelivery.domain.entity.DeliveryBasicEntity
import com.adelivery.domain.repository.DeliveryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchDeliveryBasicUseCase @Inject constructor(
    private val deliveryRepository: DeliveryRepository
) {
    suspend operator fun invoke() :Flow<List<DeliveryBasicEntity>> =
        deliveryRepository.fetchDeliveryBasic()
}