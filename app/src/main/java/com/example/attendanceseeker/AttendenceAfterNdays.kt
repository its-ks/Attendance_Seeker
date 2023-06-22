package com.example.attendanceseeker

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.attendanceseeker.ui.theme.AttendanceSeekerTheme
import kotlinx.coroutines.NonDisposableHandle.parent

class AttendenceAfterNdays : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AttendanceSeekerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(this@AttendenceAfterNdays)
                }
            }
        }
    }
}

@Composable
fun Greeting(context: Context? =null) {
    val Totallec = remember { mutableStateOf("") }
    val Days = remember { mutableStateOf("") }
    val Absent = remember { mutableStateOf("") }
    val Delegation = remember { mutableStateOf("") }
    var boxVisible = remember { mutableStateOf(false) }
    var ans = remember { mutableStateOf(0f) }
    var firstOption = remember { mutableStateOf(true) }
    var secondOption = remember { mutableStateOf(false) }
    var Mode = remember { mutableStateOf(true) }
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
                    text = "Attendance After n Days/Lectures",
                    color = Color(0xff001a39),
                    fontSize = 17.sp,
                    //fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(10.dp)
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
                OutlinedTextField(
                    value = Absent.value,

                    onValueChange = {Absent.value = it},
                    leadingIcon = {
                        Icon(Icons.Default.Edit , contentDescription = "Total Absents")
                    },
                    label = {
                        Text(text = "Enter Total Absents")
                    },
                    placeholder = {
                        Text(text = "Total Absents")
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
                Column(
                    Modifier
                        .padding(top = 10.dp, start = 30.dp, end = 30.dp)
                        .fillMaxWidth()
                ) {


                    Text(
                        text = "After Days/Lecture",
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.Serif,
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .fillMaxWidth()
                        //.padding(8.dp)
                    )
                    Row(

                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start
                    ) {

                        RadioButton(
                            selected = firstOption.value,
                            onClick = { firstOption.value = true
                                secondOption.value = false },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xff041c3d), // Change the selected radio button color
                                unselectedColor = Color(0xffbcbcc4) // Change the unselected radio button color
                            )
                        )
                        Text(text = "Days")

                        RadioButton(
                            selected = secondOption.value,
                            onClick = {firstOption.value = false
                                secondOption.value = true},
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xff041c3d), // Change the selected radio button color
                                unselectedColor = Color(0xffbcbcc4) // Change the unselected radio button color
                            )
                        )
                        Text(text = "Lectures")
                    }

                    if (firstOption.value) {
                        OutlinedTextField(
                            value = Days.value,

                            onValueChange = {Days.value = it},
                            leadingIcon = {
                                Icon(Icons.Default.Edit , contentDescription = "Days")
                            },
                            label = {
                                Text(text = "Enter Days")
                            },
                            placeholder = {
                                Text(text = "Days")
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            //.padding(top = 10.dp, start = 30.dp, end = 30.dp),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number
                            ),
                            shape = RoundedCornerShape(15.dp),
                        )
                        Mode.value=true
                    }
                    else {
                        OutlinedTextField(
                            value = Days.value,

                            onValueChange = {Days.value = it},
                            leadingIcon = {
                                Icon(Icons.Default.Edit , contentDescription = "Lectures")
                            },
                            label = {
                                Text(text = "Enter Lectures")
                            },
                            placeholder = {
                                Text(text = "Lectures")
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            //.padding(top = 10.dp, start = 30.dp, end = 30.dp),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number
                            ),
                            shape = RoundedCornerShape(15.dp),
                        )
                        Mode.value=false

                    }

                }




                var delegate = Delegation.value.toIntOrNull()
                var lec = Totallec.value.toIntOrNull()
                var absent = Absent.value.toIntOrNull()
                var days = Days.value.toIntOrNull()

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
                if(delegate==null || lec==null || absent==null || days==null)
                    {
                         boxVisible.value=false
                    }
                    if(delegate==null){ delegate=0 }
                    if(lec==null){ lec=0 }
                    if(absent==null){ absent=0 }
                    if(days==null){ days=0 }

                if(Mode.value){
                    lec=lec+(days*8)
                }
                else if(Mode.value==false){
                    lec=lec+days
                }
                    delegate = delegate*8

                    var div = remember {
                        mutableStateOf(0f)
                    }

                    div.value = ((absent).toFloat() -(delegate).toFloat())/lec
                    ans.value = (100-((div.value*100)).toFloat()).toFloat()

                if(boxVisible.value){
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        if(ans.value<=100){
                            Column(horizontalAlignment= Alignment.CenterHorizontally,
                                modifier = Modifier.fillMaxWidth()) {


                        Text(
                                text = "Your Attendance will be",
                                //text = "${ans.value} %",
                                color = Color(0xFF000A13),
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Serif,
                                textAlign = TextAlign.Center,

                                )
                            Text(
                                text = "${ans.value} %",
                                color = Color(0xFF1C074D),
                                fontSize = 20.sp,
                                fontWeight= FontWeight.Bold,
                                fontFamily = FontFamily.Serif,
                                textAlign = TextAlign.Center,

                                )}}
                        else{
                            Toast.makeText(context,"Enter Valid Inputs!",Toast.LENGTH_SHORT).show()
                        }
                      }



                    }


                        }
            }



        }
    }


@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    AttendanceSeekerTheme {
        Greeting(null)
    }
}