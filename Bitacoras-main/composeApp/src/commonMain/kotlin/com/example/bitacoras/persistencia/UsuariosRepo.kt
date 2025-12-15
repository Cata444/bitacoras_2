package com.example.bitacoras.persistencia

import com.example.bitacoras.dominio.Usuario

class UsuariosRepo {

    fun crear(usuario: Usuario) {
        BaseDatosLocal.usuarios.add(usuario)
        Storage.saveUsuarios(BaseDatosLocal.usuarios)
    }

    fun obtenerTodos(): List<Usuario> =
        BaseDatosLocal.usuarios

    fun buscarPorId(id: Int): Usuario? =
        BaseDatosLocal.usuarios.find { it.id == id }

    fun buscarPorCorreo(correo: String): Usuario? =
        BaseDatosLocal.usuarios.find { it.correo.equals(correo, true) }

    fun eliminar(id: Int) {
        BaseDatosLocal.usuarios.removeAll { it.id == id }
        Storage.saveUsuarios(BaseDatosLocal.usuarios)
    }
}
