package com.example.ejercicio3.Screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Registro(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var raza by remember { mutableStateOf("") }
    var tamano by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var fotoUrl by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(64.dp)) {
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") }
        )
        OutlinedTextField(
            value = raza,
            onValueChange = { raza = it },
            label = { Text("Raza") }
        )
        OutlinedTextField(
            value = tamano,
            onValueChange = { tamano = it },
            label = { Text("Tamaño") }
        )
        OutlinedTextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Edad") }
        )
        OutlinedTextField(
            value = fotoUrl,
            onValueChange = { fotoUrl = it },
            label = { Text("Foto URL") }
        )
        Button(
            onClick = {
                if (nombre.isNotBlank() && raza.isNotBlank() && tamano.isNotBlank() &&
                    edad.isNotBlank() && fotoUrl.isNotBlank()
                ) {
                    val edadInt = edad.toIntOrNull()
                    if (edadInt != null) {

                        navController.navigate("carnet/$nombre/$raza/$tamano/$fotoUrl")
                    } else {
                        Toast.makeText(navController.context, "Edad debe ser un número válido", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(navController.context, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Registrar")
        }
    }
}
