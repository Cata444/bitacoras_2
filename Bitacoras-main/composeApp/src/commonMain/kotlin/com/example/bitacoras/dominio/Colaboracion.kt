package com.example.bitacoras.dominio

import kotlinx.serialization.Serializable

@Serializable
sealed class Colaboracion {
    abstract val id: Int
    abstract val carrera: String
    abstract val grupo: Grupo
    abstract val inicio: String
    abstract val termino: String
    abstract val estadoGrupo: EstadoGrupo

    abstract fun tipoColaboracion(): String
}
