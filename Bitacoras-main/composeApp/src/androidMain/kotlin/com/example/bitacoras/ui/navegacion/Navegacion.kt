package com.example.bitacoras.ui.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.bitacoras.ui.pantallas.*

@Composable
fun Navegacion(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Rutas.Login.ruta
    ) {

        // LOGIN
        composable(Rutas.Login.ruta) {
            LoginPantalla(navController)
        }

        // INICIO
        composable(Rutas.Inicio.ruta) {
            InicioPantalla(navController)
        }

        // GRUPOS
        composable(Rutas.Grupos.ruta) {
            GruposPantalla(navController)
        }

        composable(Rutas.CrearGrupo.ruta) {
            CrearGrupoPantalla(navController)
        }

        // SESIONES
        composable(Rutas.Sesiones.ruta) {
            SesionesPantalla(navController)
        }

        composable(Rutas.CrearSesion.ruta) {
            CrearSesionPantalla(navController)
        }

        // BITÁCORAS
        composable(Rutas.Bitacoras.ruta) {
            BitacorasPantalla(navController)
        }

        composable(Rutas.CrearBitacora.ruta) {
            CrearBitacoraPantalla(navController)
        }
    }
}
