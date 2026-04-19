package com.example.mobiledev_clean_arch.domain.usecase

import com.example.mobiledev_clean_arch.domain.repository.IHabitRepository

class DeleteHabitUseCase(
    private val habitRepository: IHabitRepository
) {
    suspend operator fun invoke(habitId: Long) = habitRepository.delete(habitId)
}
