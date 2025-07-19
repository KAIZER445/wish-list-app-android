package com.example.wishlistapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

//@Composable
//fun Navigation(viewModel: ViewModel = viewModel(), navController: NavHostController = rememberNavController()){
//    NavHost(navController = navController,
//        startDestination = Screen.HomeScreen.route)
//    {
//        composable(Screen.HomeScreen.route){
//            HomeView()
//        }
//    }
//}

@Composable
fun Navigation(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(Screen.HomeScreen.route) {
            HomeView()
        }
    }
}