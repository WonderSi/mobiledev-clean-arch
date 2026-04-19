package com.example.mobiledev_clean_arch.ui.habitdetail

import com.example.domain.model.HabitStats

data class HabitDetailUiState(
    val stats: HabitStats? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
