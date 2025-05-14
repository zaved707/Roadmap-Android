package com.zavedahmad.androidroadmap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zavedahmad.androidroadmap.data.AppViewModel
import com.zavedahmad.androidroadmap.data.Category
import com.zavedahmad.androidroadmap.ui.DetailPage
import com.zavedahmad.androidroadmap.ui.MainPage
import com.zavedahmad.androidroadmap.ui.TestingPage

import com.zavedahmad.androidroadmap.ui.theme.AndroidRoadMapTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidRoadMapTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    MyApp(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier) {
    val viewModel: AppViewModel = viewModel()
    val navController = rememberNavController()
    MaterialTheme {
        NavHost(navController = navController, startDestination = "main") {
            composable(
                "main",
                popEnterTransition = { EnterTransition.None }, // No animation when popping back
                popExitTransition = { ExitTransition.None }) {
                MainPage(modifier, viewModel, navController)
            }
            composable(
                "detail/{categoryID}",
                enterTransition = {
                    slideInHorizontally(
                        initialOffsetX = { fullWidth -> fullWidth }, // Slide in from the right
                        animationSpec = tween(300) // 300ms duration
                    )
                },

                popEnterTransition = { EnterTransition.None }, // No animation when popping back
                popExitTransition = { ExitTransition.None }
            ) { backStackEntry ->
                // Extract categoryID as a String
                val categoryID = backStackEntry.arguments?.getString("categoryID")
                viewModel.selectedCategoryId = categoryID
                println("idgiven $categoryID")
                DetailPage(modifier, viewModel, navController)


            }
        }
    }
}
