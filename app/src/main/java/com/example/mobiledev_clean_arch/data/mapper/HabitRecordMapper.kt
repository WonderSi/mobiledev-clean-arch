package com.example.mobiledev_clean_arch.data.mapper

import com.example.mobiledev_clean_arch.data.local.entity.HabitRecordEntity
import com.example.mobiledev_clean_arch.domain.model.HabitRecord
import java.time.LocalDate

fun HabitRecordEntity.toDomain() = HabitRecord(
    id = id,
    habitId = habitId,
    completedAt = LocalDate.parse(completedAt)
)

fun HabitRecord.toEntity() = HabitRecordEntity(
    id = id,
    habitId = habitId,
    completedAt = completedAt.toString()
)
