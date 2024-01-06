package com.example.itemslist.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.itemslist.presentation.screens.ItemDetailScreen
import com.example.itemslist.presentation.screens.ItemListScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.ITEM_LIST_SCREEN
    ) {
        composable(
            route = Routes.ITEM_LIST_SCREEN
        ) {
            ItemListScreen(
                navigateToDetailsScreen = { itemId ->
                    navController.navigate(
                        route = "${Routes.ITEM_DETAIL_SCREEN}/${itemId}"
                    )
                },
                onBackCLick = { navController.navigateUp() },
                items = emptyList()
            )
        }
        composable(
            route = "${Routes.ITEM_DETAIL_SCREEN}/{itemId}",
            arguments = listOf(
                navArgument("itemId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getInt("itemId") ?: -1
            ItemDetailScreen(
                itemId = itemId,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}