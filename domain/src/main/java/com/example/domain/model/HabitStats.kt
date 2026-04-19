package com.example.domain.model

data class HabitStats(
    val habit: Habit,
    val currentStreak: Int,
    val longestStreak: Int,
    val totalCompleted: Int
)
