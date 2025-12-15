package com.example.bitacoras.persistencia

import com.example.bitacoras.dominio.Sesion

class SesionesRepo {

    fun crear(sesion: Sesion) {
        BaseDatosLocal.sesiones.add(sesion)
        Storage.saveSesiones(BaseDatosLocal.sesiones)
    }

    fun obtenerTodas(): List<Sesion> =
        BaseDatosLocal.sesiones

    fun buscarPorId(id: Int): Sesion? =
        BaseDatosLocal.sesiones.find { it.id == id }

    fun buscarPorGrupo(grupoId: Int): List<Sesion> =
        BaseDatosLocal.sesiones.filter { it.grupo.id == grupoId }

    fun eliminar(id: Int) {
        BaseDatosLocal.sesiones.removeAll { it.id == id }
        Storage.saveSesiones(BaseDatosLocal.sesiones)
    }
}
