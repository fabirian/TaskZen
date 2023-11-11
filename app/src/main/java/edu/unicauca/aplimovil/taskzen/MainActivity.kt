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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose.AppTheme
import edu.unicauca.aplimovil.taskzen.ui.Configuration.About
import edu.unicauca.aplimovil.taskzen.ui.Configuration.ConfiguracionScreen
import edu.unicauca.aplimovil.taskzen.ui.Configuration.Feedback
import edu.unicauca.aplimovil.taskzen.ui.Configuration.Help
import edu.unicauca.aplimovil.taskzen.ui.Configuration.Support
import edu.unicauca.aplimovil.taskzen.ui.Login_Register.LoginScreen
import edu.unicauca.aplimovil.taskzen.ui.ManageTask.CreateTask
import edu.unicauca.aplimovil.taskzen.ui.ManageTask.EditTask
import edu.unicauca.aplimovil.taskzen.ui.ManageTask.ListTaskScreen
import edu.unicauca.aplimovil.taskzen.ui.ManageTask.Tarea
import edu.unicauca.aplimovil.taskzen.ui.ManageTask.TaskViewModel


class MainActivity : ComponentActivity() {
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

@Composable
fun MyApp() {
    val navController = rememberNavController()
    MaterialTheme {
        Surface {
            val userViewModel = remember { UserViewModel() }
            val taskViewModel = TaskViewModel()
            val task: Tarea = Tarea(0, "00:00", "00:00", "", "", "")
            taskViewModel.addTarea(Tarea(1,"00:00", "01:00", "Tarea 1", "10", "00:00"))
            taskViewModel.addTarea(Tarea(2, "01:00", "02:00", "Tarea 2", "5", "01:00"))
            taskViewModel.addTarea(Tarea(3, "02:00", "03:00", "Tarea 3", "5", "02:00"))
            NavHost(navController, startDestination = "pantallaPrincipal") {
                composable("pantallaPrincipal") {
                    ListTaskScreen(navController, taskViewModel)
                }
                composable("CreateTask"){
                    CreateTask(navController, taskViewModel)
                }
                composable("EditTask/{taskId}") { backStackEntry ->
                    // Obtén el ID de la tarea de la URL
                    val taskId = backStackEntry.arguments?.getInt("taskId")
                    // Obtén la tarea correspondiente utilizando el ID
                    val tarea = taskId?.let { taskViewModel.getTareaById(it) }

                    // Llama a la pantalla EditTask y pasa la tarea
                    if (tarea != null) {
                        EditTask(navController, taskViewModel, tarea)
                    }else{
                        EditTask(navController, taskViewModel, task)
                    }
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

