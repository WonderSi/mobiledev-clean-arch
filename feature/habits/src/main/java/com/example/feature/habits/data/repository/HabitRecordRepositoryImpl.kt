package com.example.feature.habits.data.repository

import com.example.feature.habits.data.local.dao.HabitRecordDao
import com.example.feature.habits.data.mapper.toDomain
import com.example.feature.habits.data.mapper.toEntity
import com.example.feature.habits.domain.model.HabitRecord
import com.example.feature.habits.domain.repository.IHabitRecordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import javax.inject.Inject

class HabitRecordRepositoryImpl @Inject constructor(private val dao: HabitRecordDao) : IHabitRecordRepository {
    override fun getRecordsForHabit(habitId: Long): Flow<List<HabitRecord>> =
        dao.getRecordsForHabit(habitId).map { it.map { e -> e.toDomain() } }
    override suspend fun getRecordForDate(habitId: Long, date: LocalDate): HabitRecord? =
        dao.getRecordForDate(habitId, date.toString())?.toDomain()
    override suspend fun insert(record: HabitRecord) = dao.insert(record.toEntity())
    override suspend fun delete(id: Long) = dao.delete(id)
}
