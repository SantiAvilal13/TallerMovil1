package com.example.userlistapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.userlistapp.data.User
import com.example.userlistapp.ui.UserDetailScreen
import com.example.userlistapp.ui.UserListScreen
import com.example.userlistapp.viewmodel.UserViewModel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun UserAppNavigation(
    navController: NavHostController = rememberNavController()
) {
    // ViewModel compartido para toda la navegación
    val sharedViewModel: UserViewModel = viewModel()
    
    NavHost(
        navController = navController,
        startDestination = "user_list"
    ) {
        composable("user_list") {
            UserListScreen(
                onUserClick = { user ->
                    val userJson = Json.encodeToString(user)
                    val encodedUserJson = URLEncoder.encode(userJson, StandardCharsets.UTF_8.toString())
                    navController.navigate("user_detail/$encodedUserJson")
                },
                viewModel = sharedViewModel
            )
        }
        
        composable("user_detail/{userJson}") { backStackEntry ->
            val encodedUserJson = backStackEntry.arguments?.getString("userJson")
            val userJson = URLDecoder.decode(encodedUserJson, StandardCharsets.UTF_8.toString())
            val user = Json.decodeFromString<User>(userJson)
            
            UserDetailScreen(
                user = user,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

    }
}