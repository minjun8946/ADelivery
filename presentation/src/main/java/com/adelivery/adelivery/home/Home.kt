package com.adelivery.adelivery.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.adelivery.adelivery.component.DeliveryCheck
import com.adelivery.domain.entity.DeliveryCompanyEntity

@Composable
fun Home(viewModel: HomeViewModel = hiltViewModel()) {
    viewModel.setEvent(HomeContract.Event.OnFetchDeliveryCompany)

    val state = viewModel.uiState.collectAsState().value
    HomeScreen(viewModel, state)
}

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    state: HomeContract.State
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp)
            .background(Color.White)
    ) {
        Column {
            val textState = remember { mutableStateOf("") }
            val company = remember { mutableStateOf(DeliveryCompanyEntity("", "", "")) }
            Row(modifier = Modifier.fillMaxWidth()) {
                TrackNumberTextField(textState)
                SearchButton(textState.value, company.value.id, viewModel)
            }
            CompanyDropDown(state, company)
            ProcessColumn(state = state)
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TrackNumberTextField(
    textState: MutableState<String>,
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = textState.value,
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        placeholder = { Text(text = "운송번호를 입력해주세요") },
        onValueChange = { textValue -> textState.value = textValue },
        modifier = Modifier.padding(15.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.White,
            cursorColor = Color.Black
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        )
    )
}

@Composable
fun SearchButton(
    number: String,
    company: String,
    viewModel: HomeViewModel,
) {
    Button(
        onClick = {
            if (number != "" && company != "") viewModel.fetchDeliveryCheck(number, company)
        },
        modifier = Modifier
            .height(50.dp)
            .width(80.dp)
            .offset(x = 10.dp, y = 20.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Gray
        )
    ) {
        Text(text = "검색", fontSize = 12.sp)
    }
}

@Composable
fun CompanyDropDown(
    state: HomeContract.State,
    company: MutableState<DeliveryCompanyEntity>
) {
    val data: List<DeliveryCompanyEntity> =
        when (state.companyState) {
            is HomeContract.CompanyState.Success -> {
                state.companyState.deliveryCompany
            }
            else -> {
                println("aa ${state.companyState}")
                listOf(DeliveryCompanyEntity("", "nn", ""))
            }
        }


    val isDropDownMenuExpanded = remember { mutableStateOf(false) }
    Button(
        onClick = {
            isDropDownMenuExpanded.value = !isDropDownMenuExpanded.value
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        )
    ) {
        CompanyItems(
            data = if (company.value.id != "") company.value.name
            else "회사를 선택해주세요"
        )
    }
    DropdownMenu(
        expanded = isDropDownMenuExpanded.value,
        onDismissRequest = { isDropDownMenuExpanded.value = false },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        data.forEach { deliveryCompanyEntity ->
            DropdownMenuItem(onClick = {
                company.value = deliveryCompanyEntity
                isDropDownMenuExpanded.value = false
            }) {
                CompanyItems(data = deliveryCompanyEntity.name)
            }
        }
    }
}

@Composable
fun CompanyItems(data: String) {
    Card(
        Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(60.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        backgroundColor = Color.White

    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = data, fontSize = 24.sp)
        }
    }
}

@Composable
fun ProcessColumn(state: HomeContract.State) {
    when (state.progressState) {
        is HomeContract.ProgressState.Success -> DeliveryCheck(data = state.progressState.deliveryCheck)
        else -> {
            println(state)
        }
    }
}

