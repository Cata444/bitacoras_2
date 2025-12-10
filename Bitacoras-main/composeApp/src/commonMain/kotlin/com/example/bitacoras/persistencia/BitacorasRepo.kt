package com.example.bitacoras.persistencia

import com.example.bitacoras.dominio.Bitacora

class BitacorasRepo {

    fun crear(bitacora: Bitacora) {
        BaseDatosLocal.bitacoras.add(bitacora)
    }

    fun obtenerTodas(): List<Bitacora> {
        return BaseDatosLocal.bitacoras
    }

    fun buscarPorId(id: Int): Bitacora? {
        return BaseDatosLocal.bitacoras.find { it.id == id }
    }

    fun buscarPorSesion(sesionId: Int): Bitacora? {
        return BaseDatosLocal.bitacoras.find { it.sesion.id == sesionId }
    }

    fun eliminar(id: Int) {
        BaseDatosLocal.bitacoras.removeAll { it.id == id }
    }
}
