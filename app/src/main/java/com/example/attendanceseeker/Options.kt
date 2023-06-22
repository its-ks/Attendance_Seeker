package com.example.attendanceseeker

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.attendanceseeker.ui.theme.AttendanceSeekerTheme

class Options : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AttendanceSeekerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Options(this@Options)
                }
            }
        }
    }
}

@Composable
fun Options(context: Context? = null) {
    Box(
        modifier = with (Modifier){
            fillMaxSize()
                .paint(
                    // Replace with your image id
                    painterResource(id = R.drawable.img2),
                    contentScale = ContentScale.Crop)},
        contentAlignment = Alignment.Center)
    {
        Column(
            verticalArrangement = Arrangement.Center
        ) {


            Text(
                text = "Choose Query-",
                color = Color(0xffbdbec6),
                fontSize = 25.sp,
                //fontStyle = FontStyle.Italic,
                fontFamily = FontFamily.Cursive,
                //fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp, top = 10.dp),
            )
            Card(
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .offset(y = 20.dp)
                    .width(320.dp)
                    .height(400.dp)
                    .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
                elevation = 15.dp,
                backgroundColor = Color(0xffbdbec6)

                ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(
                        space = 5.dp,
                        alignment = Alignment.CenterVertically
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {

                    OutlinedButton(
                        onClick = {
                            val navigate = Intent(context, AttendenceAfterNdays::class.java)
                            context?.startActivity(navigate)
                        },
                        border = BorderStroke(1.dp, Color.White),
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff001a39)),
                        shape = RoundedCornerShape(15.dp)
                    )
                    {
                        Text(
                            text = "Attendance after N days/lectures",
                            color = Color.White,
                            fontSize = 20.sp,
                            //fontStyle = FontStyle.Italic,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                    OutlinedButton(
                        onClick = {
                            val navigate = Intent(context, AttendanceAfterNabsents::class.java)
                            context?.startActivity(navigate)
                        },
                        border = BorderStroke(1.dp, Color.White),
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff001a39)),
                        shape = RoundedCornerShape(15.dp)
                    )
                    {
                        Text(
                            text = "Attendance after N absents",
                            color = Color.White,
                            fontSize = 20.sp,
                            //fontStyle = FontStyle.Italic,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                    OutlinedButton(
                        onClick = {
                            val navigate = Intent(context, ToCoverAttendance::class.java)
                            context?.startActivity(navigate)
                        },
                        border = BorderStroke(1.dp, Color.White),
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff001a39)),
                        shape = RoundedCornerShape(15.dp)
                    )
                    {
                        Text(
                            text = "Days/Lectures to cover target Attendance",
                            color = Color.White,
                            fontSize = 20.sp,
                            //fontStyle = FontStyle.Italic,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                    OutlinedButton(
                        onClick = {
                            val navigate = Intent(context, Absentyoucantake::class.java)
                            context?.startActivity(navigate)
                        },
                        border = BorderStroke(1.dp, Color.White),
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff001a39)),
                        shape = RoundedCornerShape(15.dp)
                    )
                    {
                        Text(
                            text = "Absents to maintain target Attendance",
                            color = Color.White,
                            fontSize = 20.sp,
                            //fontStyle = FontStyle.Italic,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
        }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    AttendanceSeekerTheme {
        Options(null)
    }
}