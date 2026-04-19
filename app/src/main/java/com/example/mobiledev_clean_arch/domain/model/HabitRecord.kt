package com.example.mobiledev_clean_arch.domain.model

import java.time.LocalDate

data class HabitRecord(
    val id: Long = 0,
    val habitId: Long,
    val completedAt: LocalDate
)
