package com.example.bitacoras.persistencia

import com.example.bitacoras.dominio.Sesion

class SesionesRepo {

    fun crear(sesion: Sesion) {
        BaseDatosLocal.sesiones.add(sesion)
    }

    fun obtenerTodas(): List<Sesion> {
        return BaseDatosLocal.sesiones
    }

    fun buscarPorId(id: Int): Sesion? {
        return BaseDatosLocal.sesiones.find { it.id == id }
    }

    fun buscarPorGrupo(grupoId: Int): List<Sesion> {
        return BaseDatosLocal.sesiones.filter { it.grupo.id == grupoId }
    }

    fun eliminar(id: Int) {
        BaseDatosLocal.sesiones.removeAll { it.id == id }
    }
}
