package com.example.bitacoras.ui.pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bitacoras.servicios.App


@Composable
fun CrearGrupoPantalla(navController: NavController) {

    var nombreGrupo by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = "Crear / Editar Grupo",
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

        if (error.isNotEmpty()) {
            Text(
                text = error,
                color = MaterialTheme.colorScheme.error
            )
        }

        Button(
            onClick = {
                if (nombreGrupo.isBlank()) {
                    error = "El nombre no puede estar vacío"
                } else {
                    App.grupoServicio.crearGrupo(nombreGrupo)
                    navController.popBackStack()   // Volver atrás
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar")
        }
    }
}
