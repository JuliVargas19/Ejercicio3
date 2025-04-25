package com.example.ejercicio3.Screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Preview(showBackground = true)
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "registro") {
        composable("registro") {
            Registro(navController = navController)
        }
        composable("carnet/{nombre}/{raza}/{tamano}/{fotoUrl}") { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            val raza = backStackEntry.arguments?.getString("raza") ?: ""
            val tamano = backStackEntry.arguments?.getString("tamano") ?: ""
            val fotoUrl = backStackEntry.arguments?.getString("fotoUrl") ?: ""

            Carnet(nombre = nombre, raza = raza, tamano = tamano, urlFoto = fotoUrl)
        }
    }
}
