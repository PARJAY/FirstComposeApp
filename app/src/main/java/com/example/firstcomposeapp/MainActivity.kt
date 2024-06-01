package com.example.firstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcomposeapp.ui.theme.FirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column (
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        Interaksi()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column (
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
                .background(Color.Green)
                .fillMaxWidth()
        )

        Text(
            text = "I love Jetpack Compose",
            modifier = modifier
                .background(Color.Red)
                .width(200.dp)
                .height(40.dp)
        )

        Column (
            Modifier
                .size(200.dp)
                .clip(CircleShape)
                .background(Color.Blue)
        ) {

        }
    }
}

@Composable
fun Interaksi() {
    var counter by remember {
        mutableIntStateOf(0)
    }

    Column {
        Text(
            text = "$counter <- (Klik Untuk Menambah)",
            modifier = Modifier
                .clickable { counter++ }
        )

//        Button(onClick = { counter++ }) {
//            Text(text = "Klik Untuk Menambah")
//        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    FirstComposeAppTheme {
//        Greeting("Gift Worth Sharing")
//    }
//}

@Preview(showBackground = true)
@Composable
fun InteraksiPreview() {
    FirstComposeAppTheme {
        Interaksi()
    }
}