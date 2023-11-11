package edu.unicauca.aplimovil.taskzen.ui.Configuration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import edu.unicauca.aplimovil.taskzen.UserViewModel


@Composable
fun ConfiguracionScreen(navController: NavController? = null, userViewModel: UserViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.surfaceVariant)
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
                        navController.navigate("configuracion")
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
                        Text(text = "Settings")
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.onPrimary)
        ) {
            IconButton(
                onClick = {
                    if (navController != null) {
                        navController.navigate("login")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text("Login")
            }

            IconButton(
                onClick = {
                    if (navController != null) {
                        navController.navigate("help")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text("Help")
            }
            IconButton(
                onClick = {
                    if (navController != null) {
                        navController.navigate("about")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text("About Application")
            }
            IconButton(
                onClick = {
                    if (navController != null) {
                        navController.navigate("feedback")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text("Send Feedback")
            }
            IconButton(
                onClick = {
                    if (navController != null) {
                        navController.navigate("support")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text("Support")
            }

            // Muestra el nombre del usuario si está autenticado
            if (userViewModel.userEmail != null) {
                Text("Welcome, ${userViewModel.userEmail}!")
            }

            // Botón de Sign Out
            Row(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalAlignment = Alignment.Bottom
            ) {
                // Verifica si el usuario está autenticado antes de mostrar el botón de Sign Out
                if (userViewModel.userEmail != null) {
                    IconButton(
                        onClick = {
                            // Lógica para cerrar sesión (puedes limpiar el ViewModel aquí)
                            userViewModel.userEmail = null
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                            .background(MaterialTheme.colorScheme.outline)
                    ) {
                        Text("Sign Out", color = MaterialTheme.colorScheme.surface)
                    }
                }
            }
        }
    }
}



