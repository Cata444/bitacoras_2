package com.example.bitacoras.servicios

import com.example.bitacoras.dominio.Grupo
import com.example.bitacoras.persistencia.BaseDatosLocal
import com.example.bitacoras.persistencia.GruposRepo

class GrupoServicio(
    private val gruposRepo: GruposRepo = GruposRepo()
) {

    fun crearGrupo(nombre: String): Grupo {
        val grupo = Grupo(
            id = BaseDatosLocal.generarId(),
            nombre = nombre
        )

        gruposRepo.crear(grupo)
        return grupo
    }

    fun obtenerGrupos(): List<Grupo> {
        return gruposRepo.obtenerTodos()
    }

    fun buscarGrupo(id: Int): Grupo? {
        return gruposRepo.buscarPorId(id)
    }
}
