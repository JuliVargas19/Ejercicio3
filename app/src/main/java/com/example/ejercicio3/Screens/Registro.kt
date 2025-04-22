package com.example.ejercicio3.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Registro(onRegistrar: (String, String, String, String, String) -> Unit) {

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
            label = { Text("Foto url") }
        )
        Button(
            onClick = {
                onRegistrar(nombre, raza, tamano, edad, fotoUrl)
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Registrar")
        }
    }
}
