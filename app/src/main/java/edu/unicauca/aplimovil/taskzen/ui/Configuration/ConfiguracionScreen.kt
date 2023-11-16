package edu.unicauca.aplimovil.taskzen.ui.Configuration

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.unicauca.aplimovil.taskzen.ui.DataManager

@Composable
fun ConfiguracionScreen(navController: NavController? = null, dataManager: DataManager) {
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
            // Botón de Login o Nombre de Usuario
            if (dataManager.currentUser == null) {
                Text(
                    "Login",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            if (navController != null) {
                                navController.navigate("login")
                            }
                        }
                        .padding(16.dp)
                )
            } else {
                Text(
                    "Welcome, ${dataManager.currentUser?.name}!",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }

            // Otros botones
            ButtonRow(navController, "help", "Help")
            ButtonRow(navController, "about", "About Application")
            ButtonRow(navController, "feedback", "Send Feedback")
            ButtonRow(navController, "support", "Support")

            // Espaciador para separar los otros botones del botón "Sign Out"
            Spacer(modifier = Modifier.weight(1f))

            // Botón de Sign Out
            if (dataManager.currentUser != null) {
                IconButton(
                    onClick = {
                        // Lógica para cerrar sesión (puedes limpiar el edu.unicauca.aplimovil.taskzen.ui.DataManager aquí)
                        dataManager.logout()
                        // Navegar a la pantalla principal después de cerrar sesión
                        navController?.navigate("pantallaPrincipal")
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

@Composable
fun ButtonRow(navController: NavController?, route: String, text: String) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                if (navController != null) {
                    navController.navigate(route)
                }
            }
            .padding(16.dp)
    )
}
