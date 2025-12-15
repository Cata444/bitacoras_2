package com.example.bitacoras.ui.pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bitacoras.dominio.EstadoGrupo
import com.example.bitacoras.servicios.App

@Composable
fun CrearGrupoPantalla(navController: NavController, grupoId: Int?) {

    val editando = grupoId != null
    val grupo = remember(grupoId) { grupoId?.let { App.grupoServicio.buscarPorId(it) } }

    var nombreGrupo by remember { mutableStateOf(grupo?.nombre ?: "") }
    var estadoGrupo by remember { mutableStateOf(grupo?.estado ?: EstadoGrupo.PENDIENTE) }
    var error by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = if (editando) "Editar Grupo" else "Crear Grupo",
            style = MaterialTheme.typography.headlineSmall
        )

        OutlinedTextField(
            value = nombreGrupo,
            onValueChange = {
                nombreGrupo = it
                error = ""
            },
            label = { Text("Nombre del grupo") },
            modifier = Modifier.fillMaxWidth(),
            isError = error.isNotEmpty()
        )

        Text("Estado", style = MaterialTheme.typography.titleSmall)

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {

            FilterChip(
                selected = estadoGrupo == EstadoGrupo.PENDIENTE,
                onClick = { estadoGrupo = EstadoGrupo.PENDIENTE },
                label = { Text("Pendiente") }
            )

            FilterChip(
                selected = estadoGrupo == EstadoGrupo.REALIZADA,
                onClick = { estadoGrupo = EstadoGrupo.REALIZADA },
                label = { Text("Realizada") }
            )

            FilterChip(
                selected = estadoGrupo == EstadoGrupo.CANCELADA,
                onClick = { estadoGrupo = EstadoGrupo.CANCELADA },
                label = { Text("Cancelada") }
            )
        }

        if (error.isNotEmpty()) {
            Text(text = error, color = MaterialTheme.colorScheme.error)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OutlinedButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.weight(1f)
            ) { Text("Cancelar") }

            Button(
                onClick = {
                    try {
                        if (nombreGrupo.isBlank()) {
                            error = "El nombre no puede estar vacío"
                            return@Button
                        }

                        if (editando) {
                            App.grupoServicio.editarGrupo(
                                id = grupoId!!,
                                nuevoNombre = nombreGrupo,
                                nuevoEstado = estadoGrupo
                            )
                        } else {
                            App.grupoServicio.crearGrupo(nombreGrupo, estadoGrupo)
                        }

                        navController.popBackStack()
                    } catch (e: IllegalArgumentException) {
                        error = e.message ?: "Error"
                    }
                },
                modifier = Modifier.weight(1f)
            ) { Text("Guardar") }
        }
    }
}
