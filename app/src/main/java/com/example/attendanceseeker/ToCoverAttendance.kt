package com.example.attendanceseeker

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.attendanceseeker.ui.theme.AttendanceSeekerTheme
import kotlin.math.ceil
import kotlin.math.floor

class ToCoverAttendance : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AttendanceSeekerTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting3(this@ToCoverAttendance)
                }
            }
        }
    }
}


@Composable
fun Greeting3(context: Context? =null) {
    val Totallec = remember { mutableStateOf("") }
    val Percent = remember { mutableStateOf("") }
    val Absent = remember { mutableStateOf("") }
    val Delegation = remember { mutableStateOf("") }
    var boxVisible = remember { mutableStateOf(false) }
    var anslec = remember { mutableStateOf(0f) }
    var ansday = remember { mutableStateOf(0f) }
    var current = remember { mutableStateOf(0f) }
    val currAccess = remember {
        mutableStateOf(false)
    }
    Box(
        modifier = with (Modifier){
            fillMaxSize()
                .paint(
                    // Replace with your image id
                    painterResource(id = R.drawable.img2),
                    contentScale = ContentScale.Crop)

        }
    ){
        Card(
            shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
            backgroundColor = Color.White,
            modifier = Modifier
                .offset(y = 20.dp)
                .fillMaxSize()
                .padding(top = 100.dp),
            elevation = 40.dp


        ){
            Column(
                horizontalAlignment= Alignment.CenterHorizontally
            ){
                Text(
                    text = "Days/Lectures to",
                    color = Color(0xff001a39),
                    fontSize = 17.sp,
                    //fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 10.dp)
                )
                Text(
                    text = "cover target Attendance",
                    color = Color(0xff001a39),
                    fontSize = 17.sp,
                    //fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
//                    modifier = Modifier.padding(10.dp)
                )
                OutlinedTextField(
                    value = Totallec.value,

                    onValueChange = {Totallec.value = it},
                    leadingIcon = {
                        Icon(Icons.Default.Edit , contentDescription = "Total Lectures")
                    },
                    label = {
                        Text(text = "Enter Total Lectures")
                    },
                    placeholder = {
                        Text(text = "Total Lectures")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 30.dp, end = 30.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    ),
                    shape = RoundedCornerShape(15.dp),
                )
                Row(verticalAlignment = Alignment.Bottom)
                {
                    OutlinedTextField(
                        value = Absent.value,

                        onValueChange = { Absent.value = it },
                        leadingIcon = {
                            Icon(Icons.Default.Edit, contentDescription = "Total Absents")
                        },
                        label = {
                            Text(text = "Total Absents")
                        },
                        placeholder = {
                            Text(text = "Total Absents")
                        },
                        modifier = Modifier
                            .width(235.dp)
                            .padding(top = 10.dp, start = 30.dp, end = 10.dp),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number
                        ),
                        shape = RoundedCornerShape(15.dp),
                    )
                    Box(
                        modifier = Modifier
                            .padding(top = 10.dp, end = 30.dp)
                            .border(
                                border = BorderStroke(1.dp, Color.Gray),
                                shape = RoundedCornerShape(15.dp)
                            ),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Bottom,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp, top = 5.dp, bottom = 5.dp)
                                .height(47.dp)
                        ){
                            Text(
                                text = "Curr. Attend.",
                                fontSize= 13.sp,
                                style = MaterialTheme.typography.body1,
                                color = MaterialTheme.colors.onSurface
                            )
                            if(currAccess.value==true){
                            Text(
                                text = "${current.value}%",
                                fontSize= 20.sp,
                                style = MaterialTheme.typography.body1,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        }
                        else{
                                Text(
                                    text = "0.0%",
                                    fontSize= 20.sp,
                                    style = MaterialTheme.typography.body1,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                        }}}


                }
                OutlinedTextField(
                    value = Delegation.value,

                    onValueChange = {Delegation.value = it},
                    leadingIcon = {
                        Icon(Icons.Default.Edit , contentDescription = "Delegation")
                    },
                    label = {
                        Text(text = "Delegation Days")
                    },
                    placeholder = {
                        Text(text = "Delegation Days")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 30.dp, end = 30.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    ),
                    shape = RoundedCornerShape(15.dp),
                )

                OutlinedTextField(
                    value = Percent.value,

                    onValueChange = {Percent.value = it},
                    leadingIcon = {
                        Icon(Icons.Default.Edit , contentDescription = "Attendance")
                    },
                    label = {
                        Text(text = "Enter Attendance% you want")
                    },
                    placeholder = {
                        Text(text = "Attendance%")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 30.dp, end = 30.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    ),
                    shape = RoundedCornerShape(15.dp),
                )




                var delegate = Delegation.value.toIntOrNull()
                var lec = Totallec.value.toIntOrNull()
                var absent = Absent.value.toIntOrNull()
                var attend = Percent.value.toIntOrNull()

                OutlinedButton(
                    onClick = {

                        if(boxVisible.value==true)
                        {
                            boxVisible.value = false
                        }
                        else if(boxVisible.value==false)
                        {
                            boxVisible.value = true
                        }


                    },
                    modifier = Modifier
                        .padding(top = 20.dp, start = 30.dp, end = 30.dp)
                        .height(48.dp),
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color(0xff4a4e69)),
                    shape = RoundedCornerShape(25.dp)
                ) {
                    Text(
                        text = "Calculate",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.Serif,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxSize()
                        //.padding(8.dp)
                    )
                }
                if(delegate==null || lec==null || absent==null || attend==null)
                {
                    boxVisible.value=false
                }



                if(delegate!=null && lec!=null && absent!=null)
                {
                    currAccess.value=true
                }
                if(delegate==null){ delegate=0 }
                if(lec==null){ lec=0 }
                if(absent==null){ absent=0 }
                if(attend==null){ attend=0 }
                if(attend>100){ attend=0 }




                var div = remember {
                    mutableStateOf(0f)
                }



                div.value = ((absent).toFloat() -(delegate*8).toFloat())/lec
                current.value = (100-((div.value*100)).toFloat()).toFloat()


                anslec.value = (((absent-delegate).toFloat()/(100-attend).toFloat()).toFloat())*100

                anslec.value=anslec.value-lec

                ansday.value = (anslec.value/8)

                ansday.value = floor(ansday.value)

                var anslec1 = remember { mutableStateOf(0) }
                var ansday1 = remember { mutableStateOf(0) }

                anslec1.value= anslec.value.toInt()
                ansday1.value= ansday.value.toInt()

                if(boxVisible.value){
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentAlignment = Alignment.Center
                    ) {
                            Column(horizontalAlignment= Alignment.CenterHorizontally,
                                modifier = Modifier.fillMaxWidth()) {


                                Text(
                                    text = "Lectures you need to attend - ${anslec1.value}",
                                    //text = "${ans.value} %",
                                    color = Color(0xFF000A13),
                                    fontSize = 18.sp,
                                    fontFamily = FontFamily.Serif,
                                    textAlign = TextAlign.Center,

                                    )
                                Spacer(modifier = Modifier
                                    .height(8.dp)
                                    .background(color = Color.Transparent))
                                Text(
                                    text = "Days you need to come - ${ansday1.value}",
                                    color = Color(0xFF000A13),
                                    fontSize = 18.sp,
                                    //fontWeight= FontWeight.Bold,
                                    fontFamily = FontFamily.Serif,
                                    textAlign = TextAlign.Center,

                                    )}}}

                    }



                }


            }
        }





@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    AttendanceSeekerTheme {
        Greeting3()
    }
}