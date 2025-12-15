package com.example.bitacoras.servicios

import com.example.bitacoras.dominio.EstadoGrupo
import com.example.bitacoras.dominio.Grupo
import com.example.bitacoras.persistencia.BaseDatosLocal
import com.example.bitacoras.persistencia.GruposRepo

class GrupoServicio(
    private val gruposRepo: GruposRepo = GruposRepo()
) {
    fun obtenerGrupos(): List<Grupo> = gruposRepo.obtenerTodos()

    fun buscarPorId(id: Int): Grupo? = gruposRepo.buscarPorId(id)

    fun crearGrupo(nombre: String, estado: EstadoGrupo = EstadoGrupo.PENDIENTE): Grupo {
        require(nombre.isNotBlank()) { "El nombre no puede estar vacío" }

        val nuevo = Grupo(
            id = BaseDatosLocal.generarId(),
            nombre = nombre.trim(),
            estado = estado
        )
        gruposRepo.crear(nuevo)
        return nuevo
    }

    fun editarGrupo(id: Int, nuevoNombre: String, nuevoEstado: EstadoGrupo) {
        require(nuevoNombre.isNotBlank()) { "El nombre no puede estar vacío" }

        val g = gruposRepo.buscarPorId(id) ?: throw IllegalArgumentException("Grupo no encontrado")
        g.nombre = nuevoNombre.trim()
        g.estado = nuevoEstado
        gruposRepo.actualizar()
    }

    fun eliminarGrupo(id: Int) {
        gruposRepo.eliminar(id)
    }
}
