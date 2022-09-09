package com.mk.interviewprocess

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mk.interviewprocess.detail.presentation.DetailScreen
import com.mk.interviewprocess.home.presentation.HomeScreen
import com.mk.interviewprocess.navigation.Route.DETAIL
import com.mk.interviewprocess.navigation.Route.HOME
import com.mk.interviewprocess.ui.theme.InterviewProcessTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InterviewProcessTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = HOME) {
                        composable(HOME) {
                            HomeScreen(onPokemonClick = {
                                navController.navigate("$DETAIL/$it")
                            })
                        }
                        composable(
                            "$DETAIL/{pokemonId}",
                            arguments = listOf(
                                navArgument("pokemonId") {
                                    type = NavType.IntType
                                }
                            )
                        ) {
                            DetailScreen()
                        }
                    }
                }
            }
        }
    }
}
