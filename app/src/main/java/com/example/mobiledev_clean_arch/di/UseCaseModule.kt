package com.example.mobiledev_clean_arch.di

import com.example.domain.repository.IHabitRecordRepository
import com.example.domain.repository.IHabitRepository
import com.example.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetAllHabitsUseCase(repo: IHabitRepository): GetAllHabitsUseCase =
        GetAllHabitsUseCase(repo)

    @Provides
    fun provideCreateHabitUseCase(repo: IHabitRepository): CreateHabitUseCase =
        CreateHabitUseCase(repo)

    @Provides
    fun provideToggleHabitCompletionUseCase(
        habitRepo: IHabitRepository,
        recordRepo: IHabitRecordRepository
    ): ToggleHabitCompletionUseCase = ToggleHabitCompletionUseCase(habitRepo, recordRepo)

    @Provides
    fun provideGetHabitStatsUseCase(
        habitRepo: IHabitRepository,
        recordRepo: IHabitRecordRepository
    ): GetHabitStatsUseCase = GetHabitStatsUseCase(habitRepo, recordRepo)

    @Provides
    fun provideDeleteHabitUseCase(repo: IHabitRepository): DeleteHabitUseCase =
        DeleteHabitUseCase(repo)
}
