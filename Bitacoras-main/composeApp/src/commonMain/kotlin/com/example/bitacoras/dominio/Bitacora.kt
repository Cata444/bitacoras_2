package com.example.bitacoras.dominio
import kotlinx.serialization.Serializable

@Serializable
data class Bitacora(
    val id: Int,
    val sesion: Sesion,
    var resumen: String,
    var observaciones: String
) {
    fun actualizar(resumenNuevo: String, observacionesNuevas: String) {
        resumen = resumenNuevo
        observaciones = observacionesNuevas
    }
}
