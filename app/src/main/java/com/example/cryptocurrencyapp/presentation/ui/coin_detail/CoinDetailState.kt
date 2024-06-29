package com.example.cryptocurrencyapp.presentation.ui.coin_detail

import com.example.cryptocurrencyapp.domain.models.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
