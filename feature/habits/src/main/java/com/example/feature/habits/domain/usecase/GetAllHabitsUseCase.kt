package com.example.feature.habits.domain.usecase

import com.example.feature.habits.domain.model.Habit
import com.example.feature.habits.domain.repository.IHabitRepository
import kotlinx.coroutines.flow.Flow

class GetAllHabitsUseCase(private val habitRepository: IHabitRepository) {
    operator fun invoke(): Flow<List<Habit>> = habitRepository.getAll()
}
