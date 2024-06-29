package com.example.cryptocurrencyapp.presentation.ui

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cryptocurrencyapp.common.Constants
import com.example.cryptocurrencyapp.presentation.ui.coin_detail.CoinDetailScreen
import com.example.cryptocurrencyapp.presentation.ui.coin_list.CoinListScreen
import com.example.cryptocurrencyapp.presentation.ui.theme.CryptocurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screens.CoinListScreen.route
                    ) {
                        composable(route = Screens.CoinListScreen.route) {
                            CoinListScreen(navController = navController)
                        }
                        composable(route = Screens.CoinDetailScreen.route + "/{${Constants.PARAM_COIN_ID}}",
                            arguments = listOf(
                                navArgument(Constants.PARAM_COIN_ID) {
                                    type = NavType.StringType
                                }
                            )
                        ) {
                            CoinDetailScreen()
                        }

                    }

                }

            }
        }
    }
}

