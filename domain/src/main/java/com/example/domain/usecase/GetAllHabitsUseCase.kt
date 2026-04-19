package com.example.domain.usecase

import com.example.domain.model.Habit
import com.example.domain.repository.IHabitRepository
import kotlinx.coroutines.flow.Flow

class GetAllHabitsUseCase(private val habitRepository: IHabitRepository) {
    operator fun invoke(): Flow<List<Habit>> = habitRepository.getAll()
}
