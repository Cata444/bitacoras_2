package com.example.bitacoras.dominio

import kotlinx.serialization.Serializable

@Serializable
enum class EstadoGrupo {
    PENDIENTE,
    REALIZADA,
    CANCELADA
}
