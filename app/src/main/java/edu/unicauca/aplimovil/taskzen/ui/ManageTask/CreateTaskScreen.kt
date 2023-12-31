package edu.unicauca.aplimovil.taskzen.ui.ManageTask

import android.os.Build
import androidx.annotation.RequiresApi
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
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.clock.ClockDialog
import com.maxkeppeler.sheets.clock.models.ClockSelection
import edu.unicauca.aplimovil.taskzen.ui.DataManager
import edu.unicauca.aplimovil.taskzen.ui.Login_Register.Tarea
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTask(navController: NavController? = null, dataManager: DataManager){
    var titulo by remember { mutableStateOf("") }
    var duracionPausas by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("") }
    var isPlaceholderVisible by remember { mutableStateOf(true) }
    var horaInicio by remember { mutableStateOf(String.format("%02d:%02d", LocalTime.now().hour, LocalTime.now().minute)) }
    var horaFin by remember { mutableStateOf(String.format("%02d:%02d", LocalTime.now().hour+1, LocalTime.now().minute)) }
    val clockStateInicio = rememberSheetState()
    val clockStateFin = rememberSheetState()
    ClockDialog(state = clockStateInicio, selection = ClockSelection.HoursMinutes{
            horas, minutos ->
        horaInicio = String.format("%02d:%02d", horas, minutos)
    })
    ClockDialog(state = clockStateFin, selection = ClockSelection.HoursMinutes{
            horas, minutos ->
        horaFin = String.format("%02d:%02d", horas, minutos)
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
                        onClick = { clockStateInicio.show() },
                        modifier = Modifier
                            .height(60.dp)
                            .width(80.dp)) {
                        Text(
                            text = horaInicio,
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
                        onClick = { clockStateFin.show() },
                        modifier = Modifier
                            .height(60.dp)
                            .width(80.dp)) {
                        Text(
                            text = horaFin,
                            style = TextStyle(fontSize = 30.sp))
                    }
                }
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 20.dp)
                    .height(100.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
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

                Column{
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("30 minutos") },
                            onClick = {
                                selectedOption = "00:30"
                                expanded = false
                                isPlaceholderVisible = false})
                        DropdownMenuItem(
                            text = { Text("1 hora") },
                            onClick = {
                                selectedOption = "01:00"
                                expanded = false
                                isPlaceholderVisible = false})
                        DropdownMenuItem(
                            text = { Text("1 hora 30 minutos") },
                            onClick = {
                                selectedOption = "01:30"
                                expanded = false
                                isPlaceholderVisible = false})
                        DropdownMenuItem(
                            text = { Text("2 horas") },
                            onClick = {
                                selectedOption = "02:00"
                                expanded = false
                                isPlaceholderVisible = false})
                    }
                    Box(
                        modifier = Modifier
                            .clickable { expanded = true }
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            if (isPlaceholderVisible) {
                                Text(
                                    text = "Seleccionar",
                                    color = Color.Gray,
                                    textAlign = TextAlign.Center,
                                    style = TextStyle(fontSize = 16.sp))
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    tint = Color.Gray
                                )
                            } else {
                                Text(
                                    text = selectedOption,
                                    textAlign = TextAlign.Center,
                                    style = TextStyle(fontSize = 16.sp))
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowDown,
                                    contentDescription = null
                                )
                            }
                        }
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text= "Duración:",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 20.sp),
                    modifier = Modifier
                        .padding(end = 15.dp))
                TextField(
                    value = duracionPausas,
                    onValueChange = { newValue ->
                        val number = newValue.toIntOrNull()
                        if (number != null && number in 5..60) {
                            duracionPausas = newValue
                        }
                    },
                    placeholder = { Text("Ej: 5,15,20,...") },
                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                    modifier = Modifier
                        .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                        .height(50.dp)
                        .width(150.dp))
                Text(
                    text= "minutos",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 20.sp),
                    modifier = Modifier
                        .padding(start = 15.dp))
            }
        }
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center

        ){
            Button(onClick = {
                if (navController != null){
                    navController.navigate("pantallaPrincipal")
                }}) {
                Text(text = "Descartar")
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(onClick = {
                val email = dataManager.currentUser?.email ?: ""
                val tarea = Tarea(dataManager.getTareas().size, email, horaInicio, horaFin, titulo, duracionPausas, selectedOption)
                dataManager.addTarea(tarea)
                if (navController != null){
                    navController.navigate("pantallaPrincipal")
               }
            }){
                Text(text = "Guardar")
            }
        }
    }
}
