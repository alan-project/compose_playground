package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            //because both are composable
            GreetingText("Android")
//            Text("Hello Android")
        }
    }
}

@Composable
fun GreetingText(name: String) {
    //built-in composable
    Text(text = "Hello $name!",
        modifier = Modifier
            .clickable { }
            .padding(all = 24.dp)
            .width(240.dp)
            .height(200.dp),
/*        style = TextStyle(
            color = Color.Blue,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp)*/
        style = MaterialTheme.typography.h5,
        fontWeight = FontWeight.SemiBold
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingButton() {
    Button(onClick = { }) {
        GreetingText(name = "button")
        GreetingText(name = "remaining button")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewMainActivity() {
    GreetingText("world")
}