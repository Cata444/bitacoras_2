package com.example.bitacoras.dominio

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Ayudantia")
data class Ayudantia(
    override val id: Int,
    override val carrera: String,
    override val grupo: Grupo,
    override val inicio: String,
    override val termino: String,
    override val estadoGrupo: EstadoGrupo = EstadoGrupo.PENDIENTE,
    val asignatura: String
) : Colaboracion() {

    override fun tipoColaboracion(): String = "Ayudantía"
}
