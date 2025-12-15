package com.example.bitacoras.ui.navegacion

sealed class Rutas(val ruta: String) {

    object Login : Rutas("login")
    object Registro : Rutas("registro")
    object Inicio : Rutas("inicio")

    // Grupos
    object Grupos : Rutas("grupos")
    object CrearGrupo : Rutas("crear_grupo")
    object EditarGrupo : Rutas("editar_grupo/{grupoId}") {
        fun crearRuta(grupoId: Int) = "editar_grupo/$grupoId"
    }

    // Sesiones
    object Sesiones : Rutas("sesiones")
    object CrearSesion : Rutas("crear_sesion")

    // Bitácoras
    object Bitacoras : Rutas("bitacoras")
    object CrearBitacora : Rutas("crear_bitacora")
}
