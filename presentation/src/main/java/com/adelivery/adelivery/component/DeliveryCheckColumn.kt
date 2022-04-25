package com.adelivery.adelivery.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adelivery.domain.entity.DeliveryCheckEntity
import com.adelivery.domain.entity.Location
import com.adelivery.domain.entity.Progresses
import com.adelivery.domain.entity.State

@Composable
fun DeliveryCheck(data: DeliveryCheckEntity) {
    Box {
        Row(modifier = Modifier.fillMaxWidth()) {

        }
    }
}



@Composable
fun DeliveryProgressColumn(data: List<Progresses>) {

    LazyColumn(modifier = Modifier.fillMaxWidth().padding(start = 4.dp)) {
        items(items = data, itemContent = { item ->
            Box() {
                ProgressItem(data = item)
                StepsProgressBar()
            }
        })
    }
}

@Composable
fun ProgressItem(data: Progresses) {
    Card(
        Modifier
            .padding(top = 4.dp, start = 8.dp, end = 8.dp)
            .fillMaxWidth()
            .height(70.dp),
        elevation = 2.dp,
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        backgroundColor = Color.White

    ) {
        Row(horizontalArrangement = Arrangement.Start) {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = data.progressTime,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
            }
            Box(
                modifier = Modifier
                    .width(1.dp)
                    .fillMaxHeight()
                    .background(Color.LightGray)
            )
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp, start = 12.dp),
                    contentAlignment = Alignment.TopStart
                ) {
                    Text(
                        text = data.progressLocation.locationName,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,

                        )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp, start = 12.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = data.progressDescription,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light
                    )
                }
            }
        }
    }
}

@Composable
fun StepsProgressBar(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Step(
            modifier = Modifier,
        )
    }

}

@Composable
fun Step(modifier: Modifier = Modifier) {

    Box(modifier = modifier) {

        HorizontalDivider(
            modifier = Modifier.align(Alignment.Center),
            color = Color(0xFF673AB7),
            thickness = 2.dp
        )

        Canvas(modifier = Modifier
            .size(15.dp)
            .align(Alignment.CenterEnd)
            .border(
                shape = CircleShape,
                width = 2.dp,
                color = Color(0xFF673AB7)
            ),
            onDraw = {
                drawCircle(color = Color(0xFF673AB7))
            }
        )
    }
}

@Composable
fun HorizontalDivider(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.onSurface.copy(alpha = 0.12f),
    thickness: Dp = 2.dp,
    startIndent: Dp = 0.dp,
) {
    val indentMod = if (startIndent.value != 0f) {
        Modifier.padding(start = startIndent)
    } else {
        Modifier
    }
    Box(
        modifier
            .then(indentMod)
            .height(78.dp)
            .width(thickness)
            .background(color = color)
    )
}

@Preview
@Composable
fun StepsProgressBarPreview() {

    DeliveryProgressColumn(
        listOf(
            Progresses(
                State("aaa", "aaaa"),
                "10.11",
                Location("minjun"),
                "apple"
            ),
            Progresses(
                State("aaa", "aaaa"),
                "10.11",
                Location("minjun"),
                "apple"
            ),
            Progresses(
                State("aaa", "aaaa"),
                "10.11",
                Location("minjun"),
                "apple"
            ),
            Progresses(
                State("aaa", "aaaa"),
                "10.11",
                Location("minjun"),
                "apple"
            ),
            Progresses(
                State("aaa", "aaaa"),
                "10.11",
                Location("minjun"),
                "apple"
            ),
            Progresses(
                State("aaa", "aaaa"),
                "10.11",
                Location("minjun"),
                "apple"
            ),
            Progresses(
                State("aaa", "aaaa"),
                "10.11",
                Location("minjun"),
                "apple"
            ),
            Progresses(
                State("aaa", "aaaa"),
                "10.11",
                Location("minjun"),
                "apple"
            ),
            Progresses(
                State("aaa", "aaaa"),
                "10.11",
                Location("minjun"),
                "apple"
            ),
            Progresses(
                State("aaa", "aaaa"),
                "10.11",
                Location("minjun"),
                "apple"
            ),
            Progresses(
                State("aaa", "aaaa"),
                "10.11",
                Location("minjun"),
                "apple"
            ),
        )
    )

}