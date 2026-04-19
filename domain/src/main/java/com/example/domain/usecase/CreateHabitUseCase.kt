package com.example.domain.usecase

import com.example.domain.model.Habit
import com.example.domain.repository.IHabitRepository

class CreateHabitUseCase(private val habitRepository: IHabitRepository) {
    suspend operator fun invoke(title: String, description: String, color: Int): Long {
        if (title.isBlank()) throw IllegalArgumentException("Title cannot be empty")
        return habitRepository.insert(Habit(title = title, description = description, color = color))
    }
}
