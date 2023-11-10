package edu.unicauca.aplimovil.taskzen.ui.ManageTask

import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {
    private val tareas: MutableList<Tarea> = mutableListOf()

    fun addTarea(tarea: Tarea) {
        tareas.add(tarea)
    }

    fun getTareas(): List<Tarea> {
        return tareas
    }

    fun updateTarea(updatedTarea: Tarea) {
        val tareaIndex = tareas.indexOfFirst { it.id == updatedTarea.id }
        if (tareaIndex != -1) {
            tareas[tareaIndex] = updatedTarea
        }
    }
}

