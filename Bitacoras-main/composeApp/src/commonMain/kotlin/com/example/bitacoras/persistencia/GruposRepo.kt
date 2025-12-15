package com.example.bitacoras.persistencia

import com.example.bitacoras.dominio.Grupo

class GruposRepo {

    fun crear(grupo: Grupo) {
        BaseDatosLocal.grupos.add(grupo)
        Storage.saveGrupos(BaseDatosLocal.grupos)
    }

    fun obtenerTodos(): List<Grupo> =
        BaseDatosLocal.grupos

    fun buscarPorId(id: Int): Grupo? =
        BaseDatosLocal.grupos.find { it.id == id }

    fun actualizar() {
        // como el grupo se edita por referencia (var nombre/estado),
        // solo guardamos la lista completa.
        Storage.saveGrupos(BaseDatosLocal.grupos)
    }

    fun eliminar(id: Int) {
        BaseDatosLocal.grupos.removeAll { it.id == id }
        Storage.saveGrupos(BaseDatosLocal.grupos)
    }
}
