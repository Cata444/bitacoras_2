package com.example.bitacoras.ui.pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bitacoras.dominio.Sesion
import com.example.bitacoras.servicios.App
import com.example.bitacoras.ui.navegacion.Rutas

@Composable
fun CrearBitacoraPantalla(navController: NavController) {

    val sesiones = App.sesionServicio.obtenerSesiones()
    var sesionSeleccionada by remember { mutableStateOf<Sesion?>(null) }

    var resumen by remember { mutableStateOf("") }
    var observaciones by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    // Si no hay sesiones, pedimos crear una primero
    if (sesiones.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("No hay sesiones creadas. Crea una sesión primero.")
                Spacer(Modifier.height(16.dp))
                Button(onClick = { navController.navigate(Rutas.Sesiones.ruta) }) {
                    Text("Ir a sesiones")
                }
            }
        }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "Crear bitácora",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "Selecciona una sesión:",
            style = MaterialTheme.typography.bodyMedium
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 150.dp)
        ) {
            items(sesiones) { sesion ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = sesionSeleccionada == sesion,
                        onClick = {
                            sesionSeleccionada = sesion
                            error = ""
                        }
                    )
                    Column {
                        Text(text = sesion.nombre)
                        Text(
                            text = "Grupo: ${sesion.grupo.nombre}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }

        OutlinedTextField(
            value = resumen,
            onValueChange = { resumen = it; error = "" },
            label = { Text("Resumen") },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 80.dp)
        )

        OutlinedTextField(
            value = observaciones,
            onValueChange = { observaciones = it; error = "" },
            label = { Text("Observaciones") },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 80.dp)
        )

        if (error.isNotEmpty()) {
            Text(
                text = error,
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (sesionSeleccionada == null ||
                    resumen.isBlank() ||
                    observaciones.isBlank()
                ) {
                    error = "Selecciona una sesión y completa todos los campos"
                } else {
                    App.bitacoraServicio.crearBitacora(
                        sesion = sesionSeleccionada!!,
                        resumen = resumen,
                        observaciones = observaciones
                    )
                    navController.popBackStack()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar bitácora")
        }
    }
}
