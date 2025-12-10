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
fun BitacorasPantalla(navController: NavController) {

    val bitacoras = App.bitacoraServicio.obtenerBitacoras()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text(
            text = "Bitácoras",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate(Rutas.CrearBitacora.ruta) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Crear bitácora")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (bitacoras.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Aún no hay bitácoras registradas")
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(bitacoras) { bitacora ->
                    Column {
                        Text(
                            text = "Sesión: ${bitacora.sesion.nombre}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "Grupo: ${bitacora.sesion.grupo.nombre}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Resumen: ${bitacora.resumen}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}
