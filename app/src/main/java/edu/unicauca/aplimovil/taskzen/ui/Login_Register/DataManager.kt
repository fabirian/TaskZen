import edu.unicauca.aplimovil.taskzen.ui.ManageTask.Tarea

object DataManager {
    var currentUser: User? = null
    var tasks: List<Tarea> = emptyList()
    // Lista ficticia de usuarios (agrega más según sea necesario)
    private val users = mutableListOf(
        User("adrianf@unicauca.edu.co", "1234", "Adrian"),
        User("jhonnymr@unicauca.edu.co", "1234", "Mateo"),
        User("afgalindez@unicauca.edu.co", "1234", "Arlex")
    )

    private val sampleTasks = mutableListOf(
        Tarea(1, "adrianf@unicauca.edu.co", "08:00", "09:00", "Task 1", "15 mins", "08:15"),
        Tarea(2, "adrianf@unicauca.edu.co", "10:00", "11:30", "Task 2", "30 mins", "10:30"),
        Tarea(3, "jhonnymr@unicauca.edu.co", "09:30", "10:45", "Task 3", "20 mins", "09:50")

    )

    fun login(email: String, password: String): Boolean {
        // Simulación de lógica de inicio de sesión
        val user = users.find { it.email == email && it.password == password }
        if (user != null) {
            currentUser = user
            tasks = sampleTasks.filter { it.emailUser == user.email }
            return true
        }
        return false
    }
    fun registerUser(name: String, email: String, password: String): Boolean {
        // Verificar si el correo electrónico ya está registrado
        if (users.any { it.email == email }) {
            return false  // El correo electrónico ya está en uso
        }

        // Agregar el nuevo usuario a la lista
        val newUser = User(email, password, name)
        users.add(newUser)

        // Establecer el nuevo usuario como el usuario actual
        currentUser = newUser

        // Lógica adicional si es necesario

        return true  // Registro exitoso
    }

    fun logout() {
        currentUser = null
        tasks = emptyList()
    }
}
