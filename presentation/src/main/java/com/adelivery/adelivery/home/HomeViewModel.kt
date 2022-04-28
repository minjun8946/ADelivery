package com.adelivery.adelivery.home

import androidx.lifecycle.viewModelScope
import com.adelivery.adelivery.base.BaseViewModel
import com.adelivery.domain.base.*
import com.adelivery.domain.param.DeliveryCheckParam
import com.adelivery.domain.usecase.FetchDeliveryCheckUseCase
import com.adelivery.domain.usecase.FetchDeliveryCompanyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchDeliveryCompanyUseCase: FetchDeliveryCompanyUseCase,
    private val fetchDeliveryCheckUseCase: FetchDeliveryCheckUseCase,
) : BaseViewModel<HomeContract.Event, HomeContract.State, HomeContract.Effect>() {

    private fun fetchDeliveryCompany() {
        viewModelScope.launch(companyExceptionHandler) {
            fetchDeliveryCompanyUseCase().collect {
                setState { copy(companyState = HomeContract.CompanyState.Success(it)) }
            }
        }
    }

    fun fetchDeliveryCheck(num: String, company: String) {
        viewModelScope.launch(progressExceptionHandler) {
            fetchDeliveryCheckUseCase(DeliveryCheckParam(num, company)).collect {
                setState { copy(progressState = HomeContract.ProgressState.Success(it)) }
            }
        }

    }

    override fun createInitialState(): HomeContract.State {
        return HomeContract.State(
            HomeContract.CompanyState.Idle,
            HomeContract.ProgressState.Idle
        )
    }

    private val progressExceptionHandler = CoroutineExceptionHandler { a, error ->
        setState { copy(progressState = HomeContract.ProgressState.Failure) }
        when (error) {
            is NoInternetError -> setEffect { HomeContract.Effect.ShowToast("인터넷 연결을 확인해 주세요") }
            is NotFound -> setEffect { HomeContract.Effect.ShowToast("운송번호와 택배 회사를 확인해 주세요") }
            is TooManyRequest -> setEffect { HomeContract.Effect.ShowToast("잠시후 다시 시도해 주세요") }
            is BadRequest -> setEffect { HomeContract.Effect.ShowToast("운송번호를 확인해주세요") }
            else -> setEffect { HomeContract.Effect.ShowToast("알 수 없는 에러가 생겼습니다.") }

        }
    }

    private val companyExceptionHandler = CoroutineExceptionHandler { a, error ->
        setState { copy(companyState = HomeContract.CompanyState.Failure) }
        when (error) {
            is NoInternetError -> setEffect { HomeContract.Effect.ShowToast("인터넷 연결을 확인해 주세요") }
            is NotFound -> setEffect { HomeContract.Effect.ShowToast("운송번호와 택배 회사를 확인해 주세요") }
            is TooManyRequest -> setEffect { HomeContract.Effect.ShowToast("잠시후 다시 시도해 주세요") }
            is BadRequest -> setEffect { HomeContract.Effect.ShowToast("운송번호를 확인해주세요") }
            else -> setEffect { HomeContract.Effect.ShowToast("알 수 없는 에러가 발생했습니다.") }
        }
    }

    override fun handleEvent(event: HomeContract.Event) {
        when (event) {
            is HomeContract.Event.OnFetchDeliveryCompany -> {
                fetchDeliveryCompany()
            }
        }
    }

}