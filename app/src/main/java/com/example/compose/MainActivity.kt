package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {




            /**
             * Scaffold
             */
          /*  val scaffoldState = rememberScaffoldState()
            var textFieldState by remember {
                mutableStateOf("")
            }
            val scope = rememberCoroutineScope()

            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState
            ){ paddingValues->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                ) {
                    TextField(
                        value = textFieldState,
                        label = {
                            Text("Enter your name")
                        },
                        onValueChange = {
                            textFieldState = it
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
                        }

                    }) {
                        Text("Please greet me")
                    }
                }
            }*/


            /**
             * State Hoisting
             */
/*            Column(Modifier.fillMaxSize()) {
                val color = remember {
                    mutableStateOf(Color.Yellow)
                }

                ColorBox(
                    Modifier.weight(1f).fillMaxSize()
                ){
                    color.value = it
                }
                Box(modifier = Modifier
                    .background(color.value)
                    .weight(1f)
                    .fillMaxSize())
            }*/


            /**
             * Text Styling
             */
            /*
                 val fontFamily = FontFamily(
                     Font(R.font.roboto_thin, FontWeight.Thin),
                     Font(R.font.roboto_light, FontWeight.Light),
                     Font(R.font.roboto_regular, FontWeight.Normal),
                     Font(R.font.roboto_medium, FontWeight.Medium),
                     Font(R.font.roboto_bold, FontWeight.Bold),
                 )

                 Box(modifier = Modifier
                              .fillMaxSize()
                              .background(Color(0xFF101010))) {
                              Text(
                                  text = buildAnnotatedString {
                                      withStyle(
                                          style = SpanStyle(
                                              color = Color.Green,
                                              fontSize = 50.sp
                                          )
                                      ) {
                                          append("J")
                                      }
                                      append("etpack")
                                      withStyle(
                                          style = SpanStyle(
                                              color = Color.Green,
                                              fontSize = 50.sp
                                          )
                                      ) {
                                          append("C")
                                      }
                                      append("ompose")
                                  },
                                  color = Color.White,
                                  fontSize = 30.sp,
                                  fontFamily = fontFamily,
                                  fontWeight = FontWeight.Bold,
                                  fontStyle = FontStyle.Italic,
                                  textAlign = TextAlign.Center,
                                  textDecoration = TextDecoration.Underline
                              )
                          }*/


            /**
             * ImageCard
             */
/*            val painter = painterResource(id = R.drawable.rnm_temp)
            val description = "Rick and Morty"
            val title = "Rick and Morty"
            Box(modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(16.dp)) {
                ImageCard(painter = painter, contentDescription = description, title = title)
            }*/
        }
    }
}

@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit,
) {
    Box(modifier = modifier
        .background(Color.Red)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )
        }

    )
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 100f
                    )
                )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart)
            {
                Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: MainViewModel = MainViewModel()) {
    val newNameStateContent = viewModel.textFieldState.observeAsState("")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GreetingMessage(
            newNameStateContent.value
        ) { newName -> viewModel.onTextChanged(newName) }
    }
}

@Composable
fun GreetingMessage(
    textFieldValue: String,
    textFieldUpdate: (newName: String) -> Unit,
) {

    TextField(value = textFieldValue, onValueChange = textFieldUpdate)
    Button(onClick = { }) {
        Text(textFieldValue)
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        style = MaterialTheme.typography.h5
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
}