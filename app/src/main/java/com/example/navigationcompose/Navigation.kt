package com.example.navigationcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigationcompose.data.findFruit
import com.example.navigationcompose.data.fruitList
import com.example.navigationcompose.ui.screen.FruitDetailScreen
import com.example.navigationcompose.ui.screen.FruitScreen
import com.example.navigationcompose.ui.screen.MasterScreen

sealed class Screen(val route: String) {
    object MasterScreen: Screen(route = "master")
    object FruitScreen: Screen(route = "fruit_screen")
    object FruitDetailScreen: Screen(route = "fruit_detail_screen")
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Screen.MasterScreen.route) {
        composable(Screen.MasterScreen.route) {
            MasterScreen(navController)
        }

        composable(Screen.FruitScreen.route) {
            FruitScreen(navController, fruitList)
        }

        composable(route = Screen.FruitDetailScreen.route + "/{id}", arguments = listOf(
            navArgument("id") {
                type = NavType.StringType
            }
        )) { navBackStackEntry ->
            navBackStackEntry.arguments?.getString("id")?.toInt()?.let { id ->
                val fuit = findFruit(id)
                FruitDetailScreen(navController, fuit)
            }
        }
    }
}