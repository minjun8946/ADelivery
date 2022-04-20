package com.adelivery.domain.usecase

import com.adelivery.domain.entity.DeliveryCompanyEntity
import com.adelivery.domain.repository.DeliveryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchDeliveryCompanyUseCase @Inject constructor(
    private val deliveryRepository: DeliveryRepository
) {
    suspend operator fun invoke(): Flow<List<DeliveryCompanyEntity>> =
        deliveryRepository.fetchDeliveryCompany()
}