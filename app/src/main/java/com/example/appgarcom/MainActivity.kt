package com.example.appgarcom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appgarcom.ui.theme.AppGarcomTheme
import com.example.appgarcom.view.HomeView
import com.example.appgarcom.view.LoginView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppGarcomTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "login") {
                    composable("login") {
                        LoginView(navController)
                    }
                    composable("home") {
                        HomeView()
                    }

                }
            }
        }
    }
}
