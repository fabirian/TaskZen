package edu.unicauca.aplimovil.taskzen.ui.Configuration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.mlkit.vision.common.internal.ImageConvertUtils


@Composable
fun ConfiguracionScreen(navController: NavController? = null) {
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
                    }}){
                Icon(imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null)
            }
            Text("Settings")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.onPrimary)

        ){
            IconButton(onClick = {
                if(navController != null){
                    navController.navigate("login")
                }},
                modifier = Modifier
                    .fillMaxWidth()
                    ) {
                Text("Login")
            }


            IconButton(onClick = { /* Acción para ayuda */ },
                modifier = Modifier
                    .fillMaxWidth()) {
                Text("Help")
            }
            IconButton(onClick = { /* Acción para información sobre la aplicación */ },
                modifier = Modifier
                    .fillMaxWidth()) {
                Text("About Application")
            }
            IconButton(onClick = { /* Acción para enviar comentarios */ },
                modifier = Modifier
                    .fillMaxWidth()) {
                Text("Send Feedback")
            }
            IconButton(onClick = { /* Acción para soporte */ },
                modifier = Modifier
                    .fillMaxWidth()) {
                Text("Support")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxHeight(),
            verticalAlignment = Alignment.Bottom

        ){
            IconButton(onClick = { /* Acción para soporte */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .background(MaterialTheme.colorScheme.outline)) {
                Text("Sign Out", color = MaterialTheme.colorScheme.surface)
            }
        }

    }
}

@Composable
@Preview
fun Configuracion(){
    ConfiguracionScreen()
}
