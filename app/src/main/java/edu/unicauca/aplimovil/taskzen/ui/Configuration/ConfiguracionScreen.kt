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
                    if (navController != null) {
                        navController.navigate("pantallaPrincipal")
                    }
                }) {
                Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = null)
            }
            Text("Settings")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.onPrimary)
        ) {
            // Botón de Login o Nombre de Usuario
            if (DataManager.currentUser == null) {
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
                    "Welcome, ${DataManager.currentUser?.name}!",
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
            if (DataManager.currentUser != null) {
                IconButton(
                    onClick = {
                        // Lógica para cerrar sesión (puedes limpiar el DataManager aquí)
                        DataManager.logout()
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
