package com.example.mobiledev_clean_arch.domain.model

import java.time.LocalDate

data class Habit(
    val id: Long = 0,
    val title: String,
    val description: String,
    val color: Int,
    val createdAt: LocalDate = LocalDate.now()
)
