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
import com.example.bitacoras.dominio.EstadoGrupo
import com.example.bitacoras.dominio.Grupo
import com.example.bitacoras.servicios.App
import com.example.bitacoras.ui.navegacion.Rutas

@Composable
fun GruposPantalla(navController: NavController) {

    val grupos = App.grupoServicio.obtenerGrupos()
    var grupoAEliminar by remember { mutableStateOf<Grupo?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text(
            text = "Grupos",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate(Rutas.CrearGrupo.ruta) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Crear grupo")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (grupos.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Aún no hay grupos creados")
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(grupos) { grupo ->

                    val estadoTexto = when (grupo.estado) {
                        EstadoGrupo.PENDIENTE -> "Pendiente"
                        EstadoGrupo.REALIZADA -> "Realizada"
                        EstadoGrupo.CANCELADA -> "Cancelada"
                    }

                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {

                            Text(
                                text = grupo.nombre,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            AssistChip(
                                onClick = { },
                                label = { Text(estadoTexto) }
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                OutlinedButton(
                                    onClick = {
                                        navController.navigate(Rutas.EditarGrupo.crearRuta(grupo.id))
                                    },
                                    modifier = Modifier.weight(1f)
                                ) { Text("Editar") }

                                Button(
                                    onClick = { grupoAEliminar = grupo },
                                    modifier = Modifier.weight(1f)
                                ) { Text("Eliminar") }
                            }
                        }
                    }
                }
            }
        }
    }

    // Confirmación eliminar
    if (grupoAEliminar != null) {
        AlertDialog(
            onDismissRequest = { grupoAEliminar = null },
            title = { Text("Eliminar grupo") },
            text = { Text("¿Seguro que quieres eliminar \"${grupoAEliminar!!.nombre}\"?") },
            confirmButton = {
                Button(onClick = {
                    App.grupoServicio.eliminarGrupo(grupoAEliminar!!.id)
                    grupoAEliminar = null

                    // refrescar volviendo a la pantalla
                    navController.popBackStack()
                    navController.navigate(Rutas.Grupos.ruta)
                }) { Text("Sí, eliminar") }
            },
            dismissButton = {
                OutlinedButton(onClick = { grupoAEliminar = null }) { Text("Cancelar") }
            }
        )
    }
}

