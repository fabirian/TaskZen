package edu.unicauca.aplimovil.taskzen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.unicauca.aplimovil.taskzen.ui.Configuration.About
import edu.unicauca.aplimovil.taskzen.ui.Configuration.ConfiguracionScreen
import edu.unicauca.aplimovil.taskzen.ui.Configuration.Feedback
import edu.unicauca.aplimovil.taskzen.ui.Configuration.Help
import edu.unicauca.aplimovil.taskzen.ui.Configuration.Support
import edu.unicauca.aplimovil.taskzen.ui.Login_Register.LoginScreen
import edu.unicauca.aplimovil.taskzen.ui.ManageTask.CreateTask
import edu.unicauca.aplimovil.taskzen.ui.ManageTask.ListTaskScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

class UserViewModel : ViewModel() {
    var userEmail by mutableStateOf<String?>(null)
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    MaterialTheme {
        Surface {
            val userViewModel = remember { UserViewModel() }
            NavHost(navController, startDestination = "pantallaPrincipal") {
                composable("pantallaPrincipal") {
                    ListTaskScreen(navController)
                }
                composable("CreateTask"){
                    CreateTask(navController)
                }
                composable("configuracion") {
                    ConfiguracionScreen(navController,userViewModel)
                }
                composable("login") {
                    LoginScreen(navController)
                }
                composable("help") {
                    Help(navController)
                }
                composable("about") {
                    About(navController)
                }
                composable("support") {
                    Support(navController)
                }
                composable("feedback") {
                    Feedback(navController)
                }
            }
        }
    }
}

