package com.example.data.di

import com.example.data.repository.HabitRecordRepositoryImpl
import com.example.data.repository.HabitRepositoryImpl
import com.example.domain.repository.IHabitRecordRepository
import com.example.domain.repository.IHabitRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds abstract fun bindHabitRepository(impl: HabitRepositoryImpl): IHabitRepository
    @Binds abstract fun bindHabitRecordRepository(impl: HabitRecordRepositoryImpl): IHabitRecordRepository
}
