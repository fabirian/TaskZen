package edu.unicauca.aplimovil.taskzen.ui.ManageTask

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.util.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*

@Composable
fun CreateTask(navController: NavController? = null){

    var titulo by remember { mutableStateOf("") }
    var horaSeleccionada by remember { mutableStateOf(Calendar.getInstance()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background)
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .align(Alignment.Start)
        ){
            IconButton(onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()) {
                Row{
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = null)
                    Text(text = "Agregar Tarea")
                }
            }
        }
        BasicTextField(
            value = "Titulo de la Tarea",
            onValueChange = { titulo = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(10.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(100.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column {
                Text(
                    text = "Hora de inicio",
                    modifier = Modifier
                        .size(60.dp))
                Text(text = "00:00")
            }
            Column {
                Text(text = "Hora de finalizacion")
                Text(text = "00:00")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Descartar")
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(onClick = { /*TODO*/ }){
                Text(text = "Guardar")
            }
        }
    }
}

@Composable
fun EditTask(navController: NavController? = null){

}

@Composable
@Preview
fun CreateEditTaskPreview(){
    CreateTask()
}
