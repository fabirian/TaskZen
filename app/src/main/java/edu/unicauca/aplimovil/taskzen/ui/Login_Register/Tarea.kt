package edu.unicauca.aplimovil.taskzen.ui.Login_Register

data class Tarea(
    val id: Int,
    val emailUser: String,
    val horaInicio: String,
    val horaFin: String,
    val nombre: String,
    val duracionPausas: String,
    val inicioPausas: String
)
