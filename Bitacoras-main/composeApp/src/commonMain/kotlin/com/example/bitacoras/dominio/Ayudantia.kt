package com.example.bitacoras.dominio

class Ayudantia(
    id: Int,
    carrera: String,
    grupo: Grupo,
    inicio: String,
    termino: String,
    estado: Estado = Estado.PENDIENTE,
    var asignatura: String
) : Colaboracion(id, carrera, grupo, inicio, termino, estado) {

    override fun tipoColaboracion(): String = "Ayudantía"
}
