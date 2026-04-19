package com.example.mobiledev_clean_arch.ui.createhabit

data class CreateHabitUiState(
    val isLoading: Boolean = false,
    val success: Boolean = false,
    val error: String? = null
)
