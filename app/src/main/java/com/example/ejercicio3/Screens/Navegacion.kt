package com.example.ejercicio3.Screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Preview(showBackground = true)
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "registro") {
        composable("registro") {
            Registro { nombre, raza, tamano, edad, fotoUrl ->
                navController.navigate("carnet/$nombre/$raza/$tamano/$fotoUrl")
            }
        }
        composable(
            route = "carnet/{nombre}/{raza}/{tamano}/{urlFoto}",
            arguments = listOf(
                navArgument("nombre") { type = NavType.StringType },
                navArgument("raza") { type = NavType.StringType },
                navArgument("tamano") { type = NavType.StringType },
                navArgument("urlFoto") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            val raza = backStackEntry.arguments?.getString("raza") ?: ""
            val tamano = backStackEntry.arguments?.getString("tamano") ?: ""
            val urlFoto = backStackEntry.arguments?.getString("urlFoto") ?: ""

            Carnet(nombre, raza, tamano, urlFoto)
        }
    }
}
