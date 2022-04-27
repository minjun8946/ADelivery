package com.adelivery.domain.usecase

import com.adelivery.domain.entity.DeliveryCheckEntity
import com.adelivery.domain.param.DeliveryCheckParam
import com.adelivery.domain.repository.DeliveryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchDeliveryCheckUseCase @Inject constructor(
    private val deliveryRepository: DeliveryRepository
) {
    suspend operator fun invoke(deliveryCheckParam: DeliveryCheckParam): Flow<DeliveryCheckEntity> =
        deliveryRepository.fetchDeliveryCheck(deliveryCheckParam)
}