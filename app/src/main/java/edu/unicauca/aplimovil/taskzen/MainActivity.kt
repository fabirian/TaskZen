package edu.unicauca.aplimovil.taskzen

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.unicauca.aplimovil.taskzen.ui.Configuration.ConfiguracionScreen
import edu.unicauca.aplimovil.taskzen.ui.Login_Register.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    MaterialTheme {
        Surface {
            NavHost(navController, startDestination = "configuracion") {
                composable("configuracion") {
                    ConfiguracionScreen(navController)
                }
                composable("login") {
                    LoginScreen(navController)
                }
            }
        }
    }
}
