package com.example.bitacoras.persistencia

import com.example.bitacoras.dominio.*

/*
* CAMBIAR LUEGO ESTO ES PARA LA PRUEBA
* */

object BaseDatosLocal {

    private var ultimoId = 1
    fun generarId(): Int = ultimoId++

    // ==== USUARIOS ====
    val usuarios = mutableListOf(
        Usuario(
            id = generarId(),
            nombre = "Admin",
            correo = "admin@mail.com",
            contrasena = "1234",
            telefono = "999999999",
            disponibilidad = "Disponible"
        )
    )

    // ==== GRUPOS ====
    val grupos = mutableListOf<Grupo>()

    // ==== SESIONES ====
    val sesiones = mutableListOf<Sesion>()

    // ==== BITÁCORAS ====
    val bitacoras = mutableListOf<Bitacora>()
}
