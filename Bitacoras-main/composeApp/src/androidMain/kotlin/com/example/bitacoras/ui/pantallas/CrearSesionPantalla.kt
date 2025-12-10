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
import com.example.bitacoras.dominio.Grupo
import com.example.bitacoras.servicios.App
import com.example.bitacoras.ui.navegacion.Rutas
import com.example.bitacoras.servicios.Validaciones

@Composable
fun CrearSesionPantalla(navController: NavController) {

    val grupos = App.grupoServicio.obtenerGrupos()
    var grupoSeleccionado by remember { mutableStateOf<Grupo?>(null) }

    var nombre by remember { mutableStateOf("") }
    var actividad by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var horario by remember { mutableStateOf("") }
    var lugar by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    if (grupos.isEmpty()) {
        // Si no hay grupos, obligamos a crear uno primero
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("No hay grupos creados. Crea un grupo primero.")
                Spacer(Modifier.height(16.dp))
                Button(onClick = { navController.navigate(Rutas.Grupos.ruta) }) {
                    Text("Ir a grupos")
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
            text = "Crear sesión",
            style = MaterialTheme.typography.headlineSmall
        )

        // Selección de grupo
        Text(text = "Selecciona un grupo:", style = MaterialTheme.typography.bodyMedium)

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 150.dp)
        ) {
            items(grupos) { grupo ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = grupoSeleccionado == grupo,
                        onClick = {
                            grupoSeleccionado = grupo
                            error = ""
                        }
                    )
                    Text(text = grupo.nombre)
                }
            }
        }

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it; error = "" },
            label = { Text("Nombre de la sesión") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = actividad,
            onValueChange = { actividad = it; error = "" },
            label = { Text("Actividad") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = fecha,
            onValueChange = { fecha = it; error = "" },
            label = { Text("Fecha") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = horario,
            onValueChange = { horario = it; error = "" },
            label = { Text("Horario") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = lugar,
            onValueChange = { lugar = it; error = "" },
            label = { Text("Lugar") },
            modifier = Modifier.fillMaxWidth()
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
                if (grupoSeleccionado == null ||
                    nombre.isBlank() ||
                    actividad.isBlank() ||
                    fecha.isBlank() ||
                    horario.isBlank() ||
                    lugar.isBlank()
                ) {
                    error = "Completa todos los campos y selecciona un grupo"
                } else if (!Validaciones.esFechaValida(fecha)) {
                    error = "La fecha debe tener formato dd/mm/yyyy y ser una fecha real (entre 2020 y 2035)."
                } else if (!Validaciones.esHoraValida(horario)) {
                    error = "El horario debe tener formato HH:MM en 24 horas (ej: 09:30, 18:00)."
                } else {
                    App.sesionServicio.crearSesion(
                        nombre = nombre,
                        actividad = actividad,
                        grupo = grupoSeleccionado!!,
                        fecha = fecha,
                        horario = horario,
                        lugar = lugar
                    )
                    navController.popBackStack()
                }

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar sesión")
        }
    }
}
