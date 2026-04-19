package com.example.mobiledev_clean_arch.domain.usecase

import com.example.mobiledev_clean_arch.domain.model.HabitRecord
import com.example.mobiledev_clean_arch.domain.repository.IHabitRecordRepository
import com.example.mobiledev_clean_arch.domain.repository.IHabitRepository
import java.time.LocalDate

class ToggleHabitCompletionUseCase(
    private val habitRepository: IHabitRepository,
    private val recordRepository: IHabitRecordRepository
) {
    suspend operator fun invoke(habitId: Long, date: LocalDate) {
        val existing = recordRepository.getRecordForDate(habitId, date)
        if (existing != null) {
            recordRepository.delete(existing.id)
        } else {
            recordRepository.insert(HabitRecord(habitId = habitId, completedAt = date))
        }
    }
}
