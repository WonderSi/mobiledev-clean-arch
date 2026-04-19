package com.example.mobiledev_clean_arch.data.mapper

import com.example.mobiledev_clean_arch.data.local.entity.HabitEntity
import com.example.mobiledev_clean_arch.domain.model.Habit
import java.time.LocalDate

fun HabitEntity.toDomain() = Habit(
    id = id,
    title = title,
    description = description,
    color = color,
    createdAt = LocalDate.parse(createdAt)
)

fun Habit.toEntity() = HabitEntity(
    id = id,
    title = title,
    description = description,
    color = color,
    createdAt = createdAt.toString()
)
