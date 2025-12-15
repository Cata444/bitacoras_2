package com.example.bitacoras.dominio

import kotlinx.serialization.Serializable

@Serializable
data class Usuario(
    val id: Int,
    var nombre: String,
    var contrasena: String,
    var correo: String,
    var telefono: String,
    var disponibilidad: String
) {
    fun actualizarContacto(nuevoCorreo: String, nuevoTelefono: String) {
        correo = nuevoCorreo
        telefono = nuevoTelefono
    }

    fun cambiarDisponibilidad(nuevaDisponibilidad: String) {
        disponibilidad = nuevaDisponibilidad
    }
}
