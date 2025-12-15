package com.example.bitacoras.dominio
import kotlinx.serialization.Serializable

@Serializable
data class Sesion(
    val id: Int,
    val colaboracion: Colaboracion,
    var nombre: String,
    var actividad: String,
    var grupo: Grupo,
    var fecha: String,
    var horario: String,
    var lugar: String,
    var estadoGrupo: EstadoGrupo = EstadoGrupo.PENDIENTE
) {
    fun marcarRealizada() {
        estadoGrupo = EstadoGrupo.REALIZADA
    }

    fun marcarCancelada() {
        estadoGrupo = EstadoGrupo.CANCELADA
    }

    fun marcarPendiente() {
        estadoGrupo = EstadoGrupo.PENDIENTE
    }
}
