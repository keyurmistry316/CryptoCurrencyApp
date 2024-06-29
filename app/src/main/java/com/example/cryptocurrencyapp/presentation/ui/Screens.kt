package com.example.cryptocurrencyapp.presentation.ui

sealed class Screens(val route:String) {
    data object CoinListScreen : Screens("coin_list_screen")
    data object CoinDetailScreen : Screens("coin_detail_screen")
}