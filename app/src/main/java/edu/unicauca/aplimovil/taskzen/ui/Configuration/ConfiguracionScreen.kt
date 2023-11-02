package edu.unicauca.aplimovil.taskzen.ui.Configuration

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun ConfiguracionScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Pantalla de Configuración")
        Button(onClick = { navController.navigate("login") }) {
            Text("Iniciar sesión")
        }
        Button(onClick = { /* Acción para ayuda */ }) {
            Text("Ayuda")
        }
        Button(onClick = { /* Acción para información sobre la aplicación */ }) {
            Text("Acerca de la aplicación")
        }
        Button(onClick = { /* Acción para enviar comentarios */ }) {
            Text("Enviar comentarios")
        }
        Button(onClick = { /* Acción para soporte */ }) {
            Text("Soporte")
        }
    }
}
