package com.example.bitacoras.ui.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.example.bitacoras.servicios.SesionUsuario
import com.example.bitacoras.ui.pantallas.*

@Composable
fun Navegacion(navController: NavHostController) {

    val usuarioLogueado = SesionUsuario.obtenerUsuarioId()

    NavHost(
        navController = navController,
        startDestination = if (usuarioLogueado != null) Rutas.Inicio.ruta else Rutas.Login.ruta
    ) {

        composable(Rutas.Login.ruta) { LoginPantalla(navController) }
        composable(Rutas.Registro.ruta) { RegistroPantalla(navController) }

        composable(Rutas.Inicio.ruta) { InicioPantalla(navController) }

        // GRUPOS
        composable(Rutas.Grupos.ruta) { GruposPantalla(navController) }
        composable(Rutas.CrearGrupo.ruta) { CrearGrupoPantalla(navController, grupoId = null) }

        composable(
            route = Rutas.EditarGrupo.ruta,
            arguments = listOf(navArgument("grupoId") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("grupoId")
            CrearGrupoPantalla(navController, grupoId = id)
        }

        // SESIONES
        composable(Rutas.Sesiones.ruta) { SesionesPantalla(navController) }
        composable(Rutas.CrearSesion.ruta) { CrearSesionPantalla(navController) }

        // BITÁCORAS
        composable(Rutas.Bitacoras.ruta) { BitacorasPantalla(navController) }
        composable(Rutas.CrearBitacora.ruta) { CrearBitacoraPantalla(navController) }
    }
}
