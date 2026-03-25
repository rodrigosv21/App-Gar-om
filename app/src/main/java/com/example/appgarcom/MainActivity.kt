package com.example.appgarcom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appgarcom.navigation.AppRoutes
import com.example.appgarcom.ui.theme.AppGarcomTheme
import com.example.appgarcom.view.HomeView
import com.example.appgarcom.view.LoginView
import com.example.appgarcom.view.MenuView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppGarcomTheme {

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = AppRoutes.LOGIN_VIEW.route) {
                    composable(AppRoutes.LOGIN_VIEW.route) {
                        LoginView(navController)
                    }
                    composable(AppRoutes.HOME_VIEW.route) {
                        HomeView(navController)
                    }
                    composable(AppRoutes.CATEGORIES.route) {
                        MenuView(navController)
                    }
                }
            }
        }
    }
}
