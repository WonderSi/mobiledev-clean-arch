package com.example.domain.repository

import com.example.domain.model.HabitRecord
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface IHabitRecordRepository {
    fun getRecordsForHabit(habitId: Long): Flow<List<HabitRecord>>
    suspend fun getRecordForDate(habitId: Long, date: LocalDate): HabitRecord?
    suspend fun insert(record: HabitRecord)
    suspend fun delete(id: Long)
}
