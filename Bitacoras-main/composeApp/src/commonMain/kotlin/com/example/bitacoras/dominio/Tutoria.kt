package com.example.bitacoras.dominio

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Tutoria")
data class Tutoria(
    override val id: Int,
    override val carrera: String,
    override val grupo: Grupo,
    override val inicio: String,
    override val termino: String,
    override val estadoGrupo: EstadoGrupo = EstadoGrupo.PENDIENTE,
    val tema: String
) : Colaboracion() {

    override fun tipoColaboracion(): String = "Tutoría"
}
