package com.example.bitacoras.persistencia

import com.example.bitacoras.dominio.*

object BaseDatosLocal {

    // ===== ID GLOBAL =====
    private var ultimoId: Int = Storage.loadUltimoId()

    fun generarId(): Int {
        val id = ultimoId
        ultimoId++
        Storage.saveUltimoId(ultimoId)
        return id
    }

    // ===== CARGA DESDE STORAGE =====
    val usuarios: MutableList<Usuario> = Storage.loadUsuarios()
    val grupos: MutableList<Grupo> = Storage.loadGrupos()
    val sesiones: MutableList<Sesion> = Storage.loadSesiones()
    val bitacoras: MutableList<Bitacora> = Storage.loadBitacoras()

    init {
        // Crear admin SOLO si no existe (primera vez)
        if (usuarios.none { it.correo == "admin@mail.com" }) {
            usuarios.add(
                Usuario(
                    id = generarId(),
                    nombre = "Admin",
                    correo = "admin@mail.com",
                    contrasena = "1234",
                    telefono = "999999999",
                    disponibilidad = "Disponible"
                )
            )
            Storage.saveUsuarios(usuarios)
        }
    }
}
