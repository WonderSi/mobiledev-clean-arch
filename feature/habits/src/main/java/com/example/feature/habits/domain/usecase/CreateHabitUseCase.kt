package com.example.feature.habits.domain.usecase

import com.example.feature.habits.domain.model.Habit
import com.example.feature.habits.domain.repository.IHabitRepository

class CreateHabitUseCase(private val habitRepository: IHabitRepository) {
    suspend operator fun invoke(title: String, description: String, color: Int): Long {
        if (title.isBlank()) throw IllegalArgumentException("Title cannot be empty")
        return habitRepository.insert(Habit(title = title, description = description, color = color))
    }
}
