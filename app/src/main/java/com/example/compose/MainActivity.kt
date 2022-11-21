package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


private val namesList: ArrayList<String> = arrayListOf("Kim", "Elin", "Joyel", "Cho")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingList(names = namesList)
        }
    }
}

@Composable
fun GreetingList(names: List<String>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (name in names) {
            Greeting(name)
        }

        Button(onClick = { namesList.add("New Name") }) {
            Text("Add new name")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name")
}


@Composable
fun MainScreen() {
    Surface(color = Color.DarkGray, modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly) {
                ColoredSquare(Color.Blue)
                ColoredSquare(Color.Cyan)
            }
            ColoredSquare(Color.Magenta)
            ColoredSquare(Color.White)
            ColoredSquare(Color.Green)
        }
    }
}

@Composable
fun ColoredSquare(color: Color) {
    Surface(color = color, modifier = Modifier
        .height(100.dp)
        .width(100.dp)) {}
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
        fontWeight = FontWeight.SemiBold)
}

@Composable
fun DefaultPreviewMainActivity() {
    MainScreen()
}

@Preview(showBackground = true)
@Composable
fun GreetingList() {
    GreetingList(names = namesList)
}