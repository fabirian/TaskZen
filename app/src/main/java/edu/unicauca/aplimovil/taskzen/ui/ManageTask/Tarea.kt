package edu.unicauca.aplimovil.taskzen.ui.ManageTask

data class Tarea(
    val id: Int,
    val horaInicio: String,
    val horaFin: String,
    val nombre: String,
    val duracionPausas: String,
    val inicioPausas: String
)
