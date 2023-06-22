package com.example.attendanceseeker

import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.attendanceseeker.ui.theme.AttendanceSeekerTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AttendanceSeekerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xff0d1017)
                ) {
                    GetStarted(this@MainActivity)
                }
            }
        }
    }
}

@Composable
fun GetStarted(context: Context? = null) {

    var isLogoVisible = remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(3000) // Delay for 3 seconds (adjust as needed)
        isLogoVisible.value = false
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (isLogoVisible.value) {
            val scale by animateFloatAsState(
                targetValue = if (isLogoVisible.value) 1f else 0f,
                animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing)
            )

            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.scale(scale)
            )
        }
    }
    if(isLogoVisible.value==false){
    Box(
        modifier = with (Modifier){
            fillMaxSize()
                .paint(
                    // Replace with your image id
                    painterResource(id = R.drawable.img2),
                    contentScale = ContentScale.Crop)

        })
    {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(
            space = 5.dp,
            alignment = Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

                Text(
                    text = "Attendance",
                    color = Color(0xffbdbec6),
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "SEEKER",
                    color = Color(0xff7c949f),
                    fontSize = 60.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )




            OutlinedButton(
                onClick={val navigate = Intent(context , Options::class.java)
                    context?.startActivity(navigate)},
                colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color(0x80FFFFFF)),
                border = BorderStroke(2.dp, Color.White),
                modifier = Modifier
                    .fillMaxWidth(0.60f)
                    .height(120.dp)
                    .padding(35.dp),
                shape = RoundedCornerShape(25.dp)
            ){
                Text(
                    text = "Get Started!",
                    //modifier=Modifier.padding(10.dp),
                    fontWeight = FontWeight. Bold,
                    color = Color.White,
                    fontSize = 15.sp)}

            Text(
                text = "Copyright © 2023 KaushalendraSingh",
                color = Color.Gray,
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 70.dp).fillMaxWidth(),
                textAlign = TextAlign.Center

            )

        }
        }


}}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AttendanceSeekerTheme {
        GetStarted()
    }
}