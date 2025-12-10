package com.example.bitacoras.persistencia

import com.example.bitacoras.dominio.Usuario

class UsuariosRepo {

    fun crear(usuario: Usuario) {
        BaseDatosLocal.usuarios.add(usuario)
    }

    fun obtenerTodos(): List<Usuario> {
        return BaseDatosLocal.usuarios
    }

    fun buscarPorId(id: Int): Usuario? {
        return BaseDatosLocal.usuarios.find { it.id == id }
    }

    fun eliminar(id: Int) {
        BaseDatosLocal.usuarios.removeAll { it.id == id }
    }
}
