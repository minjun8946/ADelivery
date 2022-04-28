package com.adelivery.adelivery.mypage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.adelivery.adelivery.component.DeliveryCheck
import com.adelivery.domain.entity.DeliveryCheckEntity


@Composable
fun MyPage(viewModel: MyPageViewModel = hiltViewModel()) {


    viewModel.setEvent(MyPageContract.Event.OnFetchDeliveryList)

    val state = viewModel.uiState.collectAsState().value
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        DeliveryList(state = state)
    }
}

@Composable
fun DeliveryList(state: MyPageContract.State){
    when(state.deliveryList){
        is MyPageContract.DeliveryListState.Success -> { DeliveryListColumn(data = state.deliveryList.deliveryList)}
        else -> { println(state.deliveryList)}
    }
}

@Composable
fun DeliveryListColumn(data: List<DeliveryCheckEntity>){

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(12.dp)
        .padding(bottom = 50.dp)) {
        Box{
            data.map { DeliveryCheck(data = it) }
        }
    }
}