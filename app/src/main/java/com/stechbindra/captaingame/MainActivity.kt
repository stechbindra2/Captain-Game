package com.stechbindra.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stechbindra.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame()
                }
            }
        }
    }
}
@Composable
fun CaptainGame(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        val treasureFound = remember{ mutableStateOf(0) }
        val direction = remember { mutableStateOf("North") }
        val stormOrTreasure = remember { mutableStateOf("") }
        Text(text = "Trasure found : ${treasureFound.value}")
        Text(text = "Current Direction : ${direction.value}")
        Text(text = "stormOrTreasure : ${stormOrTreasure.value}")
        
        Spacer(modifier = Modifier.height(50.dp))
        Row {
            Button(onClick = {
                direction.value = "East"
                if(Random.nextBoolean()){
                    treasureFound.value+=1
                    stormOrTreasure.value = "Found a Treasure"
                }
                else{
                    stormOrTreasure.value = "Storm Ahead!"
                }
            }) {
                Text(text = "Sail East")
            }
            Spacer(modifier = Modifier.width(5.dp))

            Button(onClick = {
                direction.value = "West"
                if(Random.nextBoolean()){
                    treasureFound.value+=1
                    stormOrTreasure.value = "Found a Treasure"
                }
                else{
                    stormOrTreasure.value = "Storm Ahead!"
                }
            }) {
                Text(text = "Sail West")
            }
        }

        Row {
            Button(onClick = {
                direction.value = "South"
                if(Random.nextBoolean()){
                    treasureFound.value+=1
                    stormOrTreasure.value = "Found a Treasure"
                }
                else{
                    stormOrTreasure.value = "Storm Ahead!"
                }
            }) {
                Text(text = "Sail South")
            }
            Spacer(modifier = Modifier.width(5.dp))
            Button(onClick = {
                direction.value = "North"
                if(Random.nextBoolean()){
                    treasureFound.value+=1
                    stormOrTreasure.value = "Found a Treasure"
                }
                else{
                    stormOrTreasure.value = "Storm Ahead!"
                }
            }) {
                Text(text = "Sail North")
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun CaptainGamePreview(){
    CaptainGame()
}

