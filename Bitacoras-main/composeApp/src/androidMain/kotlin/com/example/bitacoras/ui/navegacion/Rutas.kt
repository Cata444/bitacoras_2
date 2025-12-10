package com.example.bitacoras.ui.navegacion

sealed class Rutas(val ruta: String) {

    // Sesión del usuario
    object Login : Rutas("login")
    object Inicio : Rutas("inicio")

    // Grupos
    object Grupos : Rutas("grupos")
    object CrearGrupo : Rutas("crear_grupo")

    // Sesiones
    object Sesiones : Rutas("sesiones")
    object CrearSesion : Rutas("crear_sesion")

    // Bitácoras
    object Bitacoras : Rutas("bitacoras")
    object CrearBitacora : Rutas("crear_bitacora")
}
