package com.example.bitacoras.ui.pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bitacoras.servicios.App
import com.example.bitacoras.ui.navegacion.Rutas

@Composable
fun SesionesPantalla(navController: NavController) {

    val sesiones = App.sesionServicio.obtenerSesiones()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text(
            text = "Sesiones",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate(Rutas.CrearSesion.ruta) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Crear sesión")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (sesiones.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Aún no hay sesiones creadas")
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(sesiones) { sesion ->
                    Column {
                        Text(
                            text = sesion.nombre,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "Grupo: ${sesion.grupo.nombre}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Fecha: ${sesion.fecha} • Hora: ${sesion.horario}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}
