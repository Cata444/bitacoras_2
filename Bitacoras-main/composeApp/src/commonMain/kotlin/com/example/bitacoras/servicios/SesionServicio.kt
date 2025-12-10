package com.example.bitacoras.servicios

import com.example.bitacoras.dominio.*
import com.example.bitacoras.persistencia.BaseDatosLocal
import com.example.bitacoras.persistencia.SesionesRepo

class SesionServicio(
    private val sesionesRepo: SesionesRepo = SesionesRepo()
) {

    // Crear sesión "simple": el servicio crea internamente una Ayudantía como colaboración
    fun crearSesion(
        nombre: String,
        actividad: String,
        grupo: Grupo,
        fecha: String,
        horario: String,
        lugar: String
    ): Sesion {

        val colaboracion = Ayudantia(
            id = BaseDatosLocal.generarId(),
            carrera = "Sin carrera",
            grupo = grupo,
            inicio = fecha,
            termino = fecha,
            estado = Estado.PENDIENTE,
            asignatura = actividad
        )

        val sesion = Sesion(
            id = BaseDatosLocal.generarId(),
            colaboracion = colaboracion,
            nombre = nombre,
            actividad = actividad,
            grupo = grupo,
            fecha = fecha,
            horario = horario,
            lugar = lugar,
            estado = Estado.PENDIENTE
        )

        sesionesRepo.crear(sesion)
        return sesion
    }

    fun obtenerSesiones(): List<Sesion> {
        return sesionesRepo.obtenerTodas()
    }

    fun buscarPorGrupo(grupoId: Int): List<Sesion> {
        return sesionesRepo.buscarPorGrupo(grupoId)
    }

    fun cambiarEstado(id: Int, nuevoEstado: Estado) {
        val sesion = sesionesRepo.buscarPorId(id)
        sesion?.estado = nuevoEstado
    }
}
