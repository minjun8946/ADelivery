package com.adelivery.adelivery.mypage

import androidx.lifecycle.viewModelScope
import com.adelivery.adelivery.base.BaseViewModel
import com.adelivery.adelivery.home.HomeContract
import com.adelivery.domain.base.*
import com.adelivery.domain.usecase.FetchDeliveryListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
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

    private val exceptionHandler = CoroutineExceptionHandler{ a, error ->
        setState { copy(MyPageContract.DeliveryListState.Failure) }
         MyPageContract.Effect.ShowToast("알 수 없는 문제가 발생하였습니다")
    }
}