package com.example.bitacoras.dominio

abstract class Colaboracion(
    val id: Int,
    var carrera: String,
    var grupo: Grupo,
    var inicio: String,
    var termino: String,
    var estado: Estado = Estado.PENDIENTE
) {
    abstract fun tipoColaboracion(): String

    fun marcarPendiente() {
        estado = Estado.PENDIENTE
    }

    fun marcarRealizada() {
        estado = Estado.REALIZADA
    }

    fun marcarCancelada() {
        estado = Estado.CANCELADA
    }
}
