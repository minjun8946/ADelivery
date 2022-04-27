package com.adelivery.adelivery.home

import androidx.lifecycle.viewModelScope
import com.adelivery.adelivery.base.BaseViewModel
import com.adelivery.adelivery.base.exceptionHandler
import com.adelivery.domain.param.DeliveryCheckParam
import com.adelivery.domain.usecase.FetchDeliveryCheckUseCase
import com.adelivery.domain.usecase.FetchDeliveryCompanyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchDeliveryCompanyUseCase: FetchDeliveryCompanyUseCase,
    private val fetchDeliveryCheckUseCase: FetchDeliveryCheckUseCase,
) : BaseViewModel<HomeContract.Event, HomeContract.State, HomeContract.Effect>() {

    private fun fetchDeliveryCompany() {
        viewModelScope.launch(exceptionHandler) {
            fetchDeliveryCompanyUseCase().collect {
                setState { copy(companyState = HomeContract.CompanyState.Success(it)) }
            }
        }
    }

    fun fetchDeliveryCheck(num: String, company: String) {
        viewModelScope.launch(exceptionHandler) {
            fetchDeliveryCheckUseCase(DeliveryCheckParam(num, company)).collect {
                setState { copy(progressState = HomeContract.ProgressState.Success(it)) }
                println("aaaaaa $it")
            }
        }

    }

    override fun createInitialState(): HomeContract.State {
        return HomeContract.State(
            HomeContract.CompanyState.Idle,
            HomeContract.ProgressState.Idle
        )
    }

    override fun handleEvent(event: HomeContract.Event) {
        when (event) {
            is HomeContract.Event.OnFetchDeliveryCompany -> {
                fetchDeliveryCompany()
            }
            is HomeContract.Event.OnShowToastClicked -> {
                HomeContract.Effect.ShowToast
            }
        }
    }

}