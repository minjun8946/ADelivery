package com.adelivery.adelivery.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adelivery.domain.entity.DeliveryCompanyEntity

@Composable
fun Home() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column() {
            val textState = remember { mutableStateOf("") }
            val company = remember { mutableStateOf(DeliveryCompanyEntity("", "", "")) }
            val list = listOf(
                DeliveryCompanyEntity("aa", "가나다라", "aa"),
                DeliveryCompanyEntity("bb", "가나다라", "aa"),
                DeliveryCompanyEntity("bb", "가나다라", "aa"),
                DeliveryCompanyEntity("bb", "가나다라", "aa"),
                DeliveryCompanyEntity("bb", "가나다라", "aa"),
                DeliveryCompanyEntity("bb", "가나다라", "aa"),
                DeliveryCompanyEntity("bb", "가나다라", "aa"),
                DeliveryCompanyEntity("bb", "가나다라", "aa"),
                DeliveryCompanyEntity("bb", "가나다라", "aa"),
                DeliveryCompanyEntity("bb", "가나다라", "aa"),
                DeliveryCompanyEntity("bb", "가나다라", "aa"),
                DeliveryCompanyEntity("bb", "가나다라", "aa")
            )
            Row(modifier = Modifier.fillMaxWidth()) {
                TrackNumberTextField(textState)
                SearchButton(textState.value, company.value.id)
            }
            CompanyDropDown(data = list, company)
        }
    }
}

@Composable
fun TrackNumberTextField(textState: MutableState<String>) {
    TextField(
        value = textState.value,
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        placeholder = { Text(text = "운송번호를 입력해주세요") },
        onValueChange = { textValue -> textState.value = textValue },
        modifier = Modifier.padding(15.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.White,
            cursorColor = Color.Black
        ),
    )
}

@Composable
fun SearchButton(number: String, company: String) {
    Button(
        onClick = { if (number != "" && company != "") println("$number $company") },
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
    data: List<DeliveryCompanyEntity>,
    company: MutableState<DeliveryCompanyEntity>
) {
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
        modifier = Modifier.fillMaxWidth()
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
    val color = remember { mutableStateOf(Color.White) }
    Card(
        Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(60.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        backgroundColor = color.value

    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = data, fontSize = 24.sp)
        }
    }
}


