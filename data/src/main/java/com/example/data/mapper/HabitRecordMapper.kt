package com.example.data.mapper

import com.example.data.local.entity.HabitRecordEntity
import com.example.domain.model.HabitRecord
import java.time.LocalDate

fun HabitRecordEntity.toDomain() = HabitRecord(id = id, habitId = habitId, completedAt = LocalDate.parse(completedAt))
fun HabitRecord.toEntity() = HabitRecordEntity(id = id, habitId = habitId, completedAt = completedAt.toString())
