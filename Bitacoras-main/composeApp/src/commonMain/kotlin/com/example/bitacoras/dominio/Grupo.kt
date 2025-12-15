package com.example.bitacoras.dominio

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class Grupo(
    val id: Int,
    var nombre: String,
    var estado: EstadoGrupo = EstadoGrupo.PENDIENTE,

    @Transient private val _integrantes: MutableList<Usuario> = mutableListOf(),
    @Transient private val _sesiones: MutableList<Sesion> = mutableListOf()
) {
    val integrantes: List<Usuario> get() = _integrantes
    val sesiones: List<Sesion> get() = _sesiones
}
