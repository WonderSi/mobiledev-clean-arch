package com.example.feature.stats.di

import com.example.feature.habits.domain.repository.IHabitRecordRepository
import com.example.feature.habits.domain.repository.IHabitRepository
import com.example.feature.stats.domain.usecase.DeleteHabitUseCase
import com.example.feature.stats.domain.usecase.GetHabitStatsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object StatsModule {

    @Provides
    fun provideGetHabitStatsUseCase(
        habitRepo: IHabitRepository,
        recordRepo: IHabitRecordRepository
    ): GetHabitStatsUseCase = GetHabitStatsUseCase(habitRepo, recordRepo)

    @Provides
    fun provideDeleteHabitUseCase(repo: IHabitRepository): DeleteHabitUseCase =
        DeleteHabitUseCase(repo)
}
