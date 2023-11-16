package edu.unicauca.aplimovil.taskzen

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
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
import com.example.compose.AppTheme
import edu.unicauca.aplimovil.taskzen.ui.Configuration.About
import edu.unicauca.aplimovil.taskzen.ui.Configuration.ConfiguracionScreen
import edu.unicauca.aplimovil.taskzen.ui.Configuration.Feedback
import edu.unicauca.aplimovil.taskzen.ui.Configuration.Help
import edu.unicauca.aplimovil.taskzen.ui.Configuration.Support
import edu.unicauca.aplimovil.taskzen.ui.DataManager
import edu.unicauca.aplimovil.taskzen.ui.Login_Register.LoginScreen
import edu.unicauca.aplimovil.taskzen.ui.Login_Register.RegisterScreen
import edu.unicauca.aplimovil.taskzen.ui.ManageTask.CreateTask
import edu.unicauca.aplimovil.taskzen.ui.ManageTask.EditTask
import edu.unicauca.aplimovil.taskzen.ui.ManageTask.ListTaskScreen
import edu.unicauca.aplimovil.taskzen.ui.Login_Register.Tarea


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                MyApp()
            }
        }
    }
}

class UserViewModel : ViewModel() {
    var userEmail by mutableStateOf<String?>(null)
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyApp() {
    val navController = rememberNavController()
    MaterialTheme {
        Surface {
            val userViewModel = remember { UserViewModel() }
            val dataManager = remember { DataManager }
            var task: Tarea = Tarea(0,"", "00:00", "00:00", "", "", "")
            NavHost(navController, startDestination = "pantallaPrincipal") {
                composable("pantallaPrincipal") {
                    ListTaskScreen(navController, dataManager)
                }
                composable("CreateTask"){
                    CreateTask(navController, dataManager)
                }
                composable("EditTask/{taskId}") { backStackEntry ->
                    // Obtén el ID de la tarea de la URL
                    val taskId = backStackEntry.arguments?.getInt("taskId")
                    EditTask(navController, taskId)
                }
                composable("configuracion") {
                    ConfiguracionScreen(navController, userViewModel)
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
                composable("registro") {
                    RegisterScreen(navController)
                }
            }

        }
    }
}

