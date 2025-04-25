package com.example.ejercicio3.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun Carnet(nombre: String, raza: String, tamano: String, urlFoto: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Carnet", style = MaterialTheme.typography.headlineMedium)
                Spacer(Modifier.height(20.dp))
                AsyncImage(
                    model = urlFoto,
                    contentDescription = "Foto del usuario",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.height(20.dp))
                Text("Nombre: $nombre", style = MaterialTheme.typography.bodyLarge)
                Text("Raza: $raza", style = MaterialTheme.typography.bodyLarge)
                Text("Tamaño: $tamano", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

