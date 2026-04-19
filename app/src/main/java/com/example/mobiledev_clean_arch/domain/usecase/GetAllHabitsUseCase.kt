package com.example.mobiledev_clean_arch.domain.usecase

import com.example.mobiledev_clean_arch.domain.model.Habit
import com.example.mobiledev_clean_arch.domain.repository.IHabitRepository
import kotlinx.coroutines.flow.Flow

class GetAllHabitsUseCase(
    private val habitRepository: IHabitRepository
) {
    operator fun invoke(): Flow<List<Habit>> = habitRepository.getAll()
}
