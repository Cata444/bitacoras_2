package com.example.bitacoras.dominio

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
