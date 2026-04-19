package com.example.habits.ui.habitlist

import com.example.habits.domain.model.Habit

data class HabitListUiState(
    val habits: List<Habit> = emptyList(),
    val completedTodayIds: Set<Long> = emptySet(),
    val isLoading: Boolean = false,
    val error: String? = null
)
