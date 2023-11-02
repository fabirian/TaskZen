package edu.unicauca.aplimovil.taskzen.ui.Login_Register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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

@Composable
fun LoginScreen(navController: NavController? = null) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var onLoginClick: () -> Unit ={}
    var onSignUpClick: () -> Unit ={}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Logo (You can replace this with your logo)
        Image(
            painter = painterResource(id = R.drawable.icono_logo_nombre),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // "Sign in to your account" text
        Text(
            text = "Sign in to your account",
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Email text field
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.background)
        ) {
            BasicTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email
                ),
                textStyle = MaterialTheme.typography.bodySmall.copy(color = Color.White),
                keyboardActions = KeyboardActions(
                    onDone = { /* Handle keyboard done action if needed */ }
                )
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Password text field
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.background)
                .border(1.dp, MaterialTheme.colorScheme.secondary)
        ) {
            BasicTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password
                ),
                textStyle = MaterialTheme.typography.bodySmall.copy(color = Color.White),
                visualTransformation = PasswordVisualTransformation(),
                keyboardActions = KeyboardActions(
                    onDone = { /* Handle keyboard done action if needed */ }
                )
            )
        }



        Spacer(modifier = Modifier.height(16.dp))

        // Sign in button
        Button(
            onClick = onLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Text(
                text = "Sign in",
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.White)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // "Don't have an account yet?" text
        Row() {
            Text(text = "Don't have an account yet?")
            Text(
                text = "Sign up",
                color = Color(0xFF118df0),
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}


@Composable
@Preview
fun LoginScreenPreview() {
    LoginScreen(

    )
}
