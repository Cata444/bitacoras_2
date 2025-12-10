package com.example.bitacoras.servicios

import com.example.bitacoras.dominio.Usuario
import com.example.bitacoras.persistencia.BaseDatosLocal
import com.example.bitacoras.persistencia.UsuariosRepo

class UsuarioServicio(
    private val usuariosRepo: UsuariosRepo = UsuariosRepo()
) {

    fun crearUsuario(
        nombre: String,
        contraseña: String,
        correo: String,
        telefono: String,
        disponibilidad: String
    ): Usuario {

        val usuario = Usuario(
            id = BaseDatosLocal.generarId(),
            nombre = nombre,
            contrasena = contraseña,
            correo = correo,
            telefono = telefono,
            disponibilidad = disponibilidad
        )

        usuariosRepo.crear(usuario)
        return usuario
    }

    fun obtenerUsuarios(): List<Usuario> {
        return usuariosRepo.obtenerTodos()
    }

    fun buscarUsuario(id: Int): Usuario? {
        return usuariosRepo.buscarPorId(id)
    }

    fun login(correo: String, contrasena: String): Usuario? {
        return usuariosRepo.obtenerTodos().find {
            it.correo == correo && it.contrasena == contrasena
        }
    }

}
