package com.adelivery.adelivery.mypage

import com.adelivery.adelivery.base.UiEffect
import com.adelivery.adelivery.base.UiEvent
import com.adelivery.adelivery.base.UiState
import com.adelivery.domain.entity.DeliveryCheckEntity

class MyPageContract {

    sealed class Event : UiEvent {
        object OnFetchDeliveryList : Event()
        object OnShowToastClicked : Event()
    }

    data class State(
        val deliveryList: DeliveryListState
    ) : UiState


    sealed class DeliveryListState {
        object Idle : DeliveryListState()
        object Loading : DeliveryListState()
        data class Success(val deliveryList : List<DeliveryCheckEntity>) : DeliveryListState()
    }

    sealed class Effect : UiEffect {

        object ShowToast : Effect()
    }

}