package edu.unicauca.aplimovil.taskzen.ui.ManageTask

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import edu.unicauca.aplimovil.taskzen.R

@Composable
fun ListTaskScreen(navController: NavController? = null) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        val taskViewModel = TaskViewModel()
        taskViewModel.addTarea(Tarea(1,"00:00", "01:00", "Tarea 1", "10", "00:00"))
        taskViewModel.addTarea(Tarea(2, "01:00", "02:00", "Tarea 2", "5", "01:00"))
        taskViewModel.addTarea(Tarea(3, "02:00", "03:00", "Tarea 3", "5", "02:00"))
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
                        Text(text = taskViewModel.getTareas()[0].nombre)
                    }
                    Column {
                        Text(text = "Tiempo transcurrido")
                        Text(text = "00:00")
                    }
                }
            }

            Text(text = "Tareas pendientes", modifier = Modifier.padding(top = 15.dp, bottom = 15.dp))

            LazyColumn {
                items(taskViewModel.getTareas()) { item ->
                    PendingTask(item.horaInicio, item.horaFin, item.nombre)
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
fun PendingTask(horaInicio: String, horaFin: String, nameTask: String){
    Box {
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
@Preview
fun ListTaskScreenPreview() {
    ListTaskScreen()
}
