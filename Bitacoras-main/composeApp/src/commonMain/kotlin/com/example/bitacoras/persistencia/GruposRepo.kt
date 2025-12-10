package com.example.bitacoras.persistencia

import com.example.bitacoras.dominio.Grupo

class GruposRepo {

    fun crear(grupo: Grupo) {
        BaseDatosLocal.grupos.add(grupo)
    }

    fun obtenerTodos(): List<Grupo> {
        return BaseDatosLocal.grupos
    }

    fun buscarPorId(id: Int): Grupo? {
        return BaseDatosLocal.grupos.find { it.id == id }
    }

    fun eliminar(id: Int) {
        BaseDatosLocal.grupos.removeAll { it.id == id }
    }
}
