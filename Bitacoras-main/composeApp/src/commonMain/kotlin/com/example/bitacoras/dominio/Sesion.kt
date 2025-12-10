package com.example.bitacoras.dominio

data class Sesion(
    val id: Int,
    val colaboracion: Colaboracion,
    var nombre: String,
    var actividad: String,
    var grupo: Grupo,
    var fecha: String,
    var horario: String,
    var lugar: String,
    var estado: Estado = Estado.PENDIENTE
) {
    fun marcarRealizada() {
        estado = Estado.REALIZADA
    }

    fun marcarCancelada() {
        estado = Estado.CANCELADA
    }

    fun marcarPendiente() {
        estado = Estado.PENDIENTE
    }
}
