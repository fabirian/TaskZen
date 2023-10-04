package edu.unicauca.aplimovil.tarjeta

import android.graphics.drawable.Icon
import android.os.Build
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import edu.unicauca.aplimovil.ComposeTutorial.R
import edu.unicauca.aplimovil.tarjeta.ui.theme.TarjetaTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarjetaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Card()
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Card(){
    Box(modifier = Modifier
        .background(Color.Blue)
    ){
        Column ( horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(R.drawable.unnamed),
                contentDescription ="Imagen de perfil" ,
                modifier = Modifier
                    .border(1.5.dp, MaterialTheme.colorScheme.secondary,)
                    .align(CenterHorizontally)
            )
            Text("Arlex Galindez")
            Text("Data Science")

            Spacer(modifier = Modifier.padding(60.dp))

            Column {
                Row {
                    Icon(Icons.Default.Call, contentDescription = null)
                    Text("3103430735")
                }

                Text("fabirian"

                )
                Text("fabirir99@gmail.com"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TarjetaTheme {
        Card()
    }
}