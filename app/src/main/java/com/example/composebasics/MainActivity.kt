package com.example.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //compose functions here
        setContent {
            ComposeBasicsTheme {
                App()
            }
        }
    }

}

@Composable
fun App(names : List<String> = listOf("Hello", "World")) {
    var splash by remember { mutableStateOf(true) }
    if (splash){
        SplashScreen(onContinueClicked = {splash = false})
    }else{
        Column(modifier = Modifier.padding(vertical = 4.dp)) {
            for (name in names){
                Greeting(name = name)
            }

        }
    }
}
@Composable
fun SplashScreen(onContinueClicked: () -> Unit){
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcome")
            Button(modifier = Modifier.padding(vertical = 24.dp),onClick = onContinueClicked) {
                Text(text = "Continue")
            }

        }
    }

}

@Composable
fun Greeting(name: String) {
    val expanded = remember {mutableStateOf(false)}
    val extrapadding = if (expanded.value) 48.dp else 0.dp
    Surface(color = MaterialTheme.colors.primary,

        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(extrapadding)) {
                Text(text = "Alex")
                Text(text = name)
            }
            OutlinedButton(onClick = {expanded.value = !expanded.value}) {
                Text(if (expanded.value) "Show less" else "Show more")
            }
        }
        //Text(text = "Hello $name!", modifier = Modifier.padding(25.dp))
    }
}

@Preview(showBackground = true, name = "Firstname", widthDp = 320)
@Composable
fun DefaultPreview() {
    ComposeBasicsTheme {
        App()
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun SplashPreview(){
    ComposeBasicsTheme {
        SplashScreen(onContinueClicked = {})

    }
}