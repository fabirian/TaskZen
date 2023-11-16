package edu.unicauca.aplimovil.taskzen.ui.Login_Register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import edu.unicauca.aplimovil.taskzen.R
import edu.unicauca.aplimovil.taskzen.ui.DataManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController? = null) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showErrorIncorrect by remember { mutableStateOf(false) }
    var showErrorIncomplete by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)

        // .background(MaterialTheme.colorScheme.primary)
        ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                if (navController != null) {
                    navController.navigate("configuracion")
                }
            }) {
            Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = null)
        }
        Text(
            text = "Sign in",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier
                .weight(1f)
                .wrapContentSize(Alignment.Center)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(top=30.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.icono_logo_nombre),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical=10.dp)
        )
        Text(
            modifier=Modifier
                .padding(vertical=20.dp),
            text = "Sign in to your account",
            style = MaterialTheme.typography.titleLarge  .copy(fontWeight = FontWeight.Bold)
        )
        val cornerRadius = 10.dp

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            shape = RoundedCornerShape(cornerRadius),
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(Modifier.height(10.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            shape = RoundedCornerShape(cornerRadius),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
        )
        if (showErrorIncorrect) {
            Text(
                text = "Datos incorrectos.",
                color = Color.Red,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
            )
        }

        if (showErrorIncomplete) {
            Text(
                text = "Datos incompletos.",
                color = Color.Red,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
            )
        }
        Spacer(modifier = Modifier.height(25.dp))

        // boton inicio sesion
        Button(
            onClick = {
                // Verificar si algún campo está vacío
                if (email.isEmpty() || password.isEmpty()) {
                    // Mostrar el mensaje de error de datos incompletos
                    showErrorIncorrect = false
                    showErrorIncomplete = true
                } else {
                    // Intentar iniciar sesión solo si ambos campos están completos
                    if (DataManager.login(email, password)) {
                        navController?.navigate("configuracion")
                    } else {
                        // Mostrar el mensaje de error de datos incorrectos
                        showErrorIncorrect = true
                        showErrorIncomplete = false
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(cornerRadius))
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Text(
                text = "Sign in",
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.White)
            )
        }

        Spacer(modifier = Modifier.height(25.dp))


        Row() {
            Text(text = "No tienes una cuenta?")
            // Agregar la navegación a la pantalla de registro al hacer clic en "Sign up"
            Text(
                text = "Registrarse",
                color = Color(0xFF118df0),
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.clickable {
                    navController?.navigate("registro")
                }
            )
        }
    }
}



@Composable
@Preview
fun LoginScreenPreview() {
    LoginScreen()
}
