package edu.unicauca.aplimovil.taskzen.ui.ManageTask

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.unicauca.aplimovil.taskzen.R
import edu.unicauca.aplimovil.taskzen.ui.DataManager
import kotlinx.coroutines.delay
import java.time.Duration
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ListTaskScreen(navController: NavController? = null) {
    val horaActual = LocalTime.now()

    val tareaActual = DataManager.getTareas().find { task ->
        task.horaInicio == horaActual.format(DateTimeFormatter.ofPattern("HH:mm"))
    }

    var tiempoTrascurrido by remember { mutableStateOf(0L) }

    LaunchedEffect(tareaActual) {
        tareaActual?.let {
            val startTime = LocalTime.parse(it.horaInicio)
            val endTime = LocalTime.parse(it.horaFin)
            val durationInSeconds = Duration.between(startTime, endTime).seconds

            while (tiempoTrascurrido < durationInSeconds) {
                delay(1000)
                tiempoTrascurrido++
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icono_logo),
                    contentDescription = null
                )
                Image(
                    painter = painterResource(id = R.drawable.icono_nombre),
                    contentDescription = null
                )
                IconButton(
                    onClick = {
                        if(navController != null){
                            navController.navigate("configuracion")
                        }
                    }) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            Box(
                modifier = Modifier.clip(RoundedCornerShape(15.dp))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(90.dp)
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(text = "Tarea actual")
                        if (tareaActual != null) {
                            Text(text = tareaActual.nombre)
                        } else {
                            Text(text = "Ninguna tarea en curso")
                        }
                    }
                    Column {
                        Text(text = "Tiempo transcurrido")
                        Text(text = TiempoTranscurrido(tiempoTrascurrido))
                    }
                }
            }

            Text(text = "Tareas pendientes", modifier = Modifier.padding(top = 15.dp, bottom = 15.dp))

            LazyColumn {
                items(DataManager.getTareas()) { item ->
                    PendingTask(item.id ,item.horaInicio, item.horaFin, item.nombre, navController)
                }
            }
        }

        IconButton(
            onClick = { if (navController != null){
                navController.navigate("CreateTask")
            }
                             },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(16.dp)
                .align(Alignment.BottomCenter)
        ) {
            Icon(
                imageVector = Icons.Default.AddCircle,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(100.dp)
            )
        }
    }
}

@Composable
fun PendingTask(id: Int,horaInicio: String, horaFin: String, nameTask: String, navController: NavController? = null){
    Box (
        modifier = Modifier
            .clickable{
                navController?.navigate("EditTask/${id}")
            }
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .background(MaterialTheme.colorScheme.outline),
            verticalAlignment = Alignment.CenterVertically){
            Column (modifier = Modifier.padding(16.dp)){
                Text(text = horaInicio + " - " + horaFin)
            }

            Column {
                Text(text = nameTask)
            }
        }
    }

    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun TiempoTranscurrido(seconds: Long): String {
    val horas = seconds / 3600
    val minutos = (seconds % 3600) / 60
    val segundos = seconds % 60
    return String.format("%02d:%02d:%02d", horas, minutos, segundos)
}