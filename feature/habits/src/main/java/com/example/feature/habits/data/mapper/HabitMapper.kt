package com.example.feature.habits.data.mapper

import com.example.feature.habits.data.local.entity.HabitEntity
import com.example.feature.habits.domain.model.Habit
import java.time.LocalDate

fun HabitEntity.toDomain() = Habit(id = id, title = title, description = description, color = color, createdAt = LocalDate.parse(createdAt))
fun Habit.toEntity() = HabitEntity(id = id, title = title, description = description, color = color, createdAt = createdAt.toString())
