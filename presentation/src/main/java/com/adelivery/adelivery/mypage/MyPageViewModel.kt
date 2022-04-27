package com.adelivery.adelivery.mypage

import androidx.lifecycle.viewModelScope
import com.adelivery.adelivery.base.BaseViewModel
import com.adelivery.adelivery.base.exceptionHandler
import com.adelivery.domain.usecase.FetchDeliveryListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val fetchDeliveryListUseCase: FetchDeliveryListUseCase
): BaseViewModel<MyPageContract.Event,MyPageContract.State,MyPageContract.Effect>() {

    private fun fetchDeliveryList(){
        viewModelScope.launch(exceptionHandler) {
            fetchDeliveryListUseCase().collect{
                setState { copy(MyPageContract.DeliveryListState.Success(it)) }
            }
        }
    }

    override fun handleEvent(event: MyPageContract.Event) {
        when(event){
            is MyPageContract.Event.OnFetchDeliveryList -> {fetchDeliveryList()}
            else -> { fetchDeliveryList() }
        }
    }

    override fun createInitialState(): MyPageContract.State =
        MyPageContract.State(
            MyPageContract.DeliveryListState.Idle
        )

}