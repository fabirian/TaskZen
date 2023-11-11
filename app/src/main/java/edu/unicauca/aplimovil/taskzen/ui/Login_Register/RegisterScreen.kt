package edu.unicauca.aplimovil.taskzen.ui.Login_Register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.unicauca.aplimovil.taskzen.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController? = null) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatpassword by remember { mutableStateOf("") }
    var showErrorIncomplete by remember { mutableStateOf(false) }
    var showErrorPasswordMismatch by remember { mutableStateOf(false) }
    var showSuccessMessage by remember { mutableStateOf(false) }

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
                    navController.navigate("login")
                }
            }) {
            Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = null)
        }
        Text(
            text = "Sign Up",
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



        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Create an account",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(8.dp))
        val cornerRadius = 10.dp

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            shape = RoundedCornerShape(cornerRadius),
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            shape = RoundedCornerShape(cornerRadius),
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            shape = RoundedCornerShape(cornerRadius),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
        )



        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = repeatpassword,
            onValueChange = { repeatpassword = it },
            label = { Text("Repeat Password") },
            shape = RoundedCornerShape(cornerRadius),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (showErrorPasswordMismatch) {
            Text(
                text = "Las contraseñas no coinciden.",
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

        if (showSuccessMessage) {
            Text(
                text = "Registro exitoso. ¡Bienvenido, $name!",
                color = Color.Green,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
            )
        }


        Button(
            onClick = {
                // Verificar si algún campo está vacío
                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || repeatpassword.isEmpty()) {
                    // Mostrar el mensaje de error de datos incompletos
                    showErrorIncomplete = true
                    showErrorPasswordMismatch = false
                    showSuccessMessage = false
                } else if (password != repeatpassword) {
                    // Mostrar el mensaje de error si las contraseñas no coinciden
                    showErrorIncomplete = false
                    showErrorPasswordMismatch = true
                    showSuccessMessage = false
                } else {
                    // Restablecer los mensajes de error si se intenta de nuevo
                    showErrorIncomplete = false
                    showErrorPasswordMismatch = false

                    // Lógica para registrar al usuario
                    if (DataManager.registerUser(name, email, password)) {
                        // Registro exitoso
                        showSuccessMessage = true
                    } else {
                        // Mostrar el mensaje de error si el correo electrónico ya está en uso
                        showErrorIncomplete = true
                        showErrorPasswordMismatch = false
                        showSuccessMessage = false
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Text(
                text = "Registrarse",
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.White)
            )
        }
        // Enlace para iniciar sesión si ya tienes una cuenta
        Row() {
            Text(text = "Ya tienes cuenta?")

            Text(
                text = "Inicia Sesion",
                color = Color(0xFF118df0),
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.clickable {
                    navController?.navigate("login")               }
            )
        }
    }
    }

@Composable
@Preview
fun RegisterScreenPreview() {
    RegisterScreen()
}

