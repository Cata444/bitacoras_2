package com.example.bitacoras.ui.pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bitacoras.servicios.SesionUsuario
import com.example.bitacoras.ui.navegacion.Rutas

@Composable
fun InicioPantalla(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Bitácoras",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate(Rutas.Grupos.ruta) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Grupos")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { navController.navigate(Rutas.Sesiones.ruta) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sesiones")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { navController.navigate(Rutas.Bitacoras.ruta) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Bitácoras")
        }

        Spacer(modifier = Modifier.height(32.dp))

        // 🔴 CERRAR SESIÓN
        OutlinedButton(
            onClick = {
                SesionUsuario.cerrarSesion()
                navController.navigate(Rutas.Login.ruta) {
                    popUpTo(Rutas.Inicio.ruta) { inclusive = true }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cerrar sesión")
        }
    }
}
