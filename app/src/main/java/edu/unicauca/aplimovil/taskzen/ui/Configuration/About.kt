package edu.unicauca.aplimovil.taskzen.ui.Configuration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.unicauca.aplimovil.taskzen.ui.Utils.TitleSection

@Composable
fun About(navController: NavController? = null) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column {
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
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = null
                    )
                }
                Text("About")
            }
            TitleSection("Contacto")
            Text(
                "Puedes contactarnos en support@taskzen.com para obtener ayuda adicional.",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp)
            )
            TitleSection("Acerca de la aplicación")
            Text(
                "TaskZen v1.0.0",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                "© 2023 TaskZen Technologies",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
@Preview
fun AboutPreview() {
    About()
}
