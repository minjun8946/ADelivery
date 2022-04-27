package com.adelivery.adelivery.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adelivery.adelivery.util.day
import com.adelivery.adelivery.util.locationName
import com.adelivery.adelivery.util.time
import com.adelivery.domain.entity.*

@Composable
fun DeliveryCheck(data: DeliveryCheckEntity?) {
    Card(
        backgroundColor = Color.White,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(data)
    }
}


@Composable
private fun CardContent(data: DeliveryCheckEntity?) {
    val expanded = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
            ) {
                Text(
                    text = data?.state?.stateText ?: "정보가 없습니다.",
                    style = MaterialTheme.typography.h5
                )
                Text(
                    text = data?.from?.fromName ?: "정보가 없습니다",
                    style = MaterialTheme.typography.h4.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
            }

            IconButton(onClick = { expanded.value = !expanded.value }) {
                Icon(
                    imageVector = if (expanded.value) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = if (expanded.value) {
                        stringResource(id = R.string.on)
                    } else {
                        stringResource(id = R.string.off)
                    }
                )
            }
        }
        if (expanded.value) {
            DeliveryProgressColumn(data?.progressList)
        }
    }

}

@Composable
fun DeliveryProgressColumn(data: List<Progresses>?) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp)
    ) {
        items(items = data!!, itemContent = { item ->
            Box {
                ProgressItem(data = item)
                //StepsProgressBar()
            }
        })
    }
}


@Composable
fun ProgressItem(data: Progresses) {
    Card(
        Modifier
            .fillMaxWidth()
            .height(135.dp),
        elevation = 8.dp,
        backgroundColor = Color.White

    ) {
        Row(horizontalArrangement = Arrangement.Start) {
            Column(
                modifier = Modifier
                    .width(100.dp)
                    .padding(start = 20.dp,top = 40.dp)
                    .fillMaxHeight()
            ) {
                Text(
                    text = day(data.progressTime),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
                Text(
                    text = time(data.progressTime),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 4.dp, start = 8.dp)
                )
            }
            Box(
                modifier = Modifier
                    .width(1.dp)
                    .fillMaxHeight()
                    .background(Color.White)
            )
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Start)
                        .padding(start = 4.dp, top = 4.dp),
                    contentAlignment = Alignment.TopStart
                ) {
                    Text(
                        text = locationName(data.progressLocation.locationName),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,

                        )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(
                        text = data.progressDescription,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light,
                        maxLines = 2
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
            color = Color(0xFF000000),
            thickness = 2.dp
        )

        Canvas(modifier = Modifier
            .size(15.dp)
            .align(Alignment.CenterEnd)
            .border(
                shape = CircleShape,
                width = 2.dp,
                color = Color(0xFF99CCFF)
            ),
            onDraw = {
                drawCircle(color = Color(0xFF99CCFF))
            }
        )
    }
}

@Composable
fun HorizontalDivider(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.onSurface.copy(alpha = 0.12f),
    thickness: Dp = 2.dp,
) {
    Box(
        modifier
            .then(Modifier)
            .height(135.dp)
            .width(thickness)
            .background(color = color)
    )
}

@Preview
@Composable
fun StepsProgressBarPreview() {

    val list = listOf(
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

    DeliveryCheck(
        data = DeliveryCheckEntity(
            "1111111", "id",
            From("10:11", "person1"),
            TO("10:11", ""),
            State("going", "hello"),
            list
        )
    )

}