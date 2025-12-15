package com.example.bitacoras.servicios

import com.example.bitacoras.dominio.Usuario
import com.example.bitacoras.persistencia.BaseDatosLocal
import com.example.bitacoras.persistencia.UsuariosRepo

class UsuarioServicio(
    private val usuariosRepo: UsuariosRepo = UsuariosRepo()
) {

    fun login(correo: String, contrasena: String): Usuario? {
        val u = usuariosRepo.buscarPorCorreo(correo) ?: return null
        return if (u.contrasena == contrasena) u else null
    }

    fun registrar(
        nombre: String,
        correo: String,
        contrasena: String,
        telefono: String,
        disponibilidad: String = "Disponible"
    ): Usuario {

        // Validaciones mínimas (puedes usar tu clase Validaciones después si quieres)
        require(nombre.isNotBlank()) { "El nombre es obligatorio" }
        require(correo.isNotBlank()) { "El correo es obligatorio" }
        require(contrasena.isNotBlank()) { "La contraseña es obligatoria" }

        if (usuariosRepo.buscarPorCorreo(correo) != null) {
            throw IllegalArgumentException("Ese correo ya está registrado")
        }

        val nuevo = Usuario(
            id = BaseDatosLocal.generarId(),
            nombre = nombre.trim(),
            correo = correo.trim(),
            contrasena = contrasena,
            telefono = telefono.trim(),
            disponibilidad = disponibilidad
        )

        usuariosRepo.crear(nuevo) // esto ya guarda en Storage
        return nuevo
    }

    fun obtenerUsuarios(): List<Usuario> =
        usuariosRepo.obtenerTodos()
}
