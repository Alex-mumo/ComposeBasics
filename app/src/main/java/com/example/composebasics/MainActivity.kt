package com.example.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
                // A surface container using the 'background' color from the theme
                //Surface(color = MaterialTheme.colors.background) {
                    //Greeting("Alex")

            }
        }
    }


}
@Composable
private fun App() {
    Surface(color = MaterialTheme.colors.background){
        Greeting("Alex")

    }
}

@Composable
fun Greeting(name: String) {
    Surface(color = MaterialTheme.colors.primary) {
        Text(text = "Hello $name!", modifier = Modifier.padding(25.dp))
    }
}


@Preview(showBackground = true, name = "Firstname")
@Composable
fun DefaultPreview() {
    ComposeBasicsTheme {
        App()
    }
}