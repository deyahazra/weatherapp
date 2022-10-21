package com.example.weatherapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.*
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime.now
import java.time.LocalTime
import java.util.*


@Composable
fun HomeScreen() {

    Box(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxSize()
    )
    {
        Column {
            placeName()
            TimeForcast(chips = listOf("9 a.m","10 a.m","11.am","12 a.m"))
            weekForcast(chips = listOf("1","2"))
        }
    }
}


@Composable
    fun placeName(
        name: String = "Kolkata",
        temp:Int=24,
        date: LocalDate = LocalDate.now()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
        ) {
            Column(verticalArrangement = Arrangement.Center)
            {
                Row() {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_location_on_24),
                        contentDescription = "location",
                        tint = Color.Red,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(top = 20.dp)
                            .aspectRatio(1f)
                    )
                    Text(
                        text = name,
                        style = MaterialTheme.typography.h2,
                        fontSize = 40.sp,

                    )

                }

                Text(
                    text = "We wish you have an awesome day!",
                    style = MaterialTheme.typography.body1,
                    color = TextWhite,
                    fontSize = 20.sp

                )
                Row() {
                    Text(
                        text = "$temp",
                        style = MaterialTheme.typography.h1,
                        fontSize = 60.sp,
                        color = TextWhite,

                    )
                    Text(
                        text = "°C",
                        style = MaterialTheme.typography.h1,
                        color = TextWhite,
                        modifier = Modifier.padding(top=16.dp)
                    )

                }
                Text(
                    text = "$date",
                    style = MaterialTheme.typography.h1,
                    color = TextWhite)

            }

        }
    }
@Composable
fun TimeForcast(
    chips:List<String>,
    time: LocalTime = LocalTime.now()
){
    val rightNow = Calendar.getInstance()
    var hour: Int = rightNow.get(Calendar.HOUR)
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow{
        items(12){
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, bottom = 15.dp, top = 15.dp)
                    .padding(15.dp)

            )
            {
                Column() {
                    Text(
                        text = "$hour:00",
                        style = MaterialTheme.typography.body1,
                        color = TextWhite
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.rain),
                        contentDescription = "location",
                        tint = Color.Red,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(top = 20.dp)
                            .aspectRatio(1f))

                        hour+=2

                }

            }

        }
    }
}
@Composable
fun weekForcast(
    day:String= LocalDate.now().dayOfWeek.name ,
    chips:List<String>) {
    LazyColumn (
        contentPadding = PaddingValues( bottom =100.dp )
            ){
        items(7) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(15.dp)
                    .padding(horizontal = 15.dp, vertical = 20.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = day,
                    style = MaterialTheme.typography.body1,
                    color = TextWhite
                )
                Icon(
                    painter = painterResource(id = R.drawable.cloudy),
                    contentDescription = "location",
                    tint = Color.Red,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(top = 20.dp)
                        .aspectRatio(1f)
                )

            }
            
        }
    }
}

