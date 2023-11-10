package edu.unicauca.aplimovil.taskzen.ui.ManageTask

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.maxkeppeker.sheets.core.models.base.SelectionButton
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.clock.ClockDialog
import com.maxkeppeler.sheets.clock.models.ClockSelection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTask(navController: NavController? = null){
    var titulo by remember { mutableStateOf("") }
    var horaSeleccionada by remember { mutableStateOf("00:00") }
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Selecciona una opción") }
    var isPlaceholderVisible by remember { mutableStateOf(true) }
    val clockState = rememberSheetState()
    ClockDialog(state = clockState, selection = ClockSelection.HoursMinutes{
            horas, minutos ->
        horaSeleccionada = "$horas:$minutos"
    })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(MaterialTheme.colorScheme.primary),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    if(navController != null){
                        navController.navigate("pantallaPrincipal")
                    }
                },
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = null,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Text(text = "Agregar Tarea")
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ){
            TextField(
                value = titulo,
                onValueChange = { titulo = it },
                placeholder = { Text("Titulo Tarea") },
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                    .height(50.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.onPrimary)
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp)
                    .height(100.dp),
                horizontalArrangement = Arrangement.Center
            ){
                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    Text(
                        text = "Hora\nInicio:",
                        textAlign = TextAlign.Center,
                        style = TextStyle(fontSize = 20.sp),
                        modifier = Modifier
                            .border(1.dp, Color.Black)
                            .padding(10.dp, 0.dp))
                    IconButton(
                        onClick = { clockState.show() },
                        modifier = Modifier
                            .height(60.dp)
                            .width(80.dp)) {
                        Text(
                            text = horaSeleccionada,
                            style = TextStyle(fontSize = 30.sp))
                    }

                }

                Spacer(modifier = Modifier.width(50.dp))

                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    Text(
                        text = "Hora\nFinalización:",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 20.sp),
                        modifier = Modifier
                            .border(1.dp, Color.Black)
                            .padding(10.dp, 0.dp))
                    IconButton(
                        onClick = { clockState.show() },
                        modifier = Modifier
                            .height(60.dp)
                            .width(80.dp)) {
                        Text(
                            text = horaSeleccionada,
                            style = TextStyle(fontSize = 30.sp))
                    }
                }
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 20.dp)
                    .height(100.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "¿Cada cuanto\nrealizara\npausas activas?",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 20.sp),
                    modifier = Modifier
                        .border(1.dp, Color.Black)
                        .padding(10.dp, 0.dp))

                Spacer(modifier = Modifier.width(50.dp))

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Option 1") },
                        onClick = {
                            selectedOption = "Option 1"
                            expanded = false
                            isPlaceholderVisible = false})
                    DropdownMenuItem(
                        text = { Text("Option 2") },
                        onClick = {
                            selectedOption = "Option 2"
                            expanded = false
                            isPlaceholderVisible = false})
                    DropdownMenuItem(
                        text = { Text("Option 3") },
                        onClick = {
                            selectedOption = "Option 3"
                            expanded = false
                            isPlaceholderVisible = false})
                }
                Box(
                    modifier = Modifier
                        .clickable { expanded = true }
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        if (isPlaceholderVisible) {
                            Text("Seleccionar", color = Color.Gray)
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = null
                            )
                        } else {
                            Text(selectedOption)
                        }
                    }
                }

            }
        }
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center

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
