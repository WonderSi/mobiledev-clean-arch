package com.example.mobiledev_clean_arch.ui.habitlist

import com.example.mobiledev_clean_arch.domain.model.Habit

data class HabitListUiState(
    val habits: List<Habit> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
