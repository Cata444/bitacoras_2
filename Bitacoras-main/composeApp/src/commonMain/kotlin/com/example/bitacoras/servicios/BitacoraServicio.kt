package com.example.bitacoras.servicios

import com.example.bitacoras.dominio.*
import com.example.bitacoras.persistencia.BaseDatosLocal
import com.example.bitacoras.persistencia.BitacorasRepo

class BitacoraServicio(
    private val bitacorasRepo: BitacorasRepo = BitacorasRepo()
) {

    fun crearBitacora(
        sesion: Sesion,
        resumen: String,
        observaciones: String
    ): Bitacora {

        val bitacora = Bitacora(
            id = BaseDatosLocal.generarId(),
            sesion = sesion,
            resumen = resumen,
            observaciones = observaciones
        )

        bitacorasRepo.crear(bitacora)
        return bitacora
    }

    fun obtenerBitacoras(): List<Bitacora> {
        return bitacorasRepo.obtenerTodas()
    }

    fun buscarPorSesion(sesionId: Int): Bitacora? {
        return bitacorasRepo.buscarPorSesion(sesionId)
    }
}
