package com.example.bitacoras.dominio

class Grupo(
    val id: Int,
    var nombre: String
) {
    // Listas internas para mostrar encapsulamiento
    private val _integrantes = mutableListOf<Usuario>()
    val integrantes: List<Usuario> get() = _integrantes

    private val _sesiones = mutableListOf<Sesion>()
    val sesiones: List<Sesion> get() = _sesiones

    fun agregarIntegrante(usuario: Usuario) {
        if (!_integrantes.contains(usuario)) {
            _integrantes.add(usuario)
        }
    }

    fun quitarIntegrante(usuario: Usuario) {
        _integrantes.remove(usuario)
    }

    fun agregarSesion(sesion: Sesion) {
        if (!_sesiones.contains(sesion)) {
            _sesiones.add(sesion)
        }
    }
}
