package com.example.feature.habits.di

import com.example.feature.habits.domain.repository.IHabitRecordRepository
import com.example.feature.habits.domain.repository.IHabitRepository
import com.example.feature.habits.domain.usecase.CreateHabitUseCase
import com.example.feature.habits.domain.usecase.GetAllHabitsUseCase
import com.example.feature.habits.domain.usecase.ToggleHabitCompletionUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object HabitsModule {

    @Provides
    fun provideGetAllHabitsUseCase(repo: IHabitRepository): GetAllHabitsUseCase =
        GetAllHabitsUseCase(repo)

    @Provides
    fun provideCreateHabitUseCase(repo: IHabitRepository): CreateHabitUseCase =
        CreateHabitUseCase(repo)

    @Provides
    fun provideToggleUseCase(
        habitRepo: IHabitRepository,
        recordRepo: IHabitRecordRepository
    ): ToggleHabitCompletionUseCase = ToggleHabitCompletionUseCase(habitRepo, recordRepo)
}
