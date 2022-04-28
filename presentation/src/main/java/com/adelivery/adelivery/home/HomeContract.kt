package com.adelivery.adelivery.home

import com.adelivery.adelivery.base.UiEffect
import com.adelivery.adelivery.base.UiEvent
import com.adelivery.adelivery.base.UiState
import com.adelivery.data.local.entity.DeliveryCheckRoomEntity
import com.adelivery.domain.entity.DeliveryCheckEntity
import com.adelivery.domain.entity.DeliveryCompanyEntity

class HomeContract {

    sealed class Event : UiEvent {
        object OnFetchDeliveryCompany : Event()
    }

    data class State(
        val companyState: CompanyState,
        val progressState: ProgressState
    ) : UiState


    sealed class CompanyState {
        object Idle : CompanyState()
        object Failure : CompanyState()
        data class Success(val deliveryCompany : List<DeliveryCompanyEntity>) : CompanyState()
    }

    sealed class ProgressState {
        object Idle : ProgressState()
        object Failure: ProgressState()
        data class Success(val deliveryCheck : DeliveryCheckEntity?) : ProgressState()
    }

    sealed class Effect : UiEffect {

        data class ShowToast(val msg: String) : Effect()
    }

}