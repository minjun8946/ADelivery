package com.adelivery.domain.usecase

import com.adelivery.domain.entity.DeliveryCheckEntity
import com.adelivery.domain.repository.DeliveryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchDeliveryListUseCase @Inject constructor(
    private val deliveryRepository: DeliveryRepository
) {
    suspend operator fun invoke(): Flow<List<DeliveryCheckEntity>> =
        deliveryRepository.fetchDeliveryList()
}