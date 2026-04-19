package com.example.feature.stats.domain.model

import com.example.feature.habits.domain.model.Habit

data class HabitStats(
    val habit: Habit,
    val currentStreak: Int,
    val longestStreak: Int,
    val totalCompleted: Int
)
