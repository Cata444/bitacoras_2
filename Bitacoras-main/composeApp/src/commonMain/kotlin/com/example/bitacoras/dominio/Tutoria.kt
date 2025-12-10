package com.example.bitacoras.dominio

class Tutoria(
    id: Int,
    carrera: String,
    grupo: Grupo,
    inicio: String,
    termino: String,
    estado: Estado = Estado.PENDIENTE
) : Colaboracion(id, carrera, grupo, inicio, termino, estado) {

    override fun tipoColaboracion(): String = "Tutoría"
}
