package com.example.mobiledev_clean_arch.data.repository

import com.example.mobiledev_clean_arch.data.local.dao.HabitRecordDao
import com.example.mobiledev_clean_arch.data.mapper.toDomain
import com.example.mobiledev_clean_arch.data.mapper.toEntity
import com.example.mobiledev_clean_arch.domain.model.HabitRecord
import com.example.mobiledev_clean_arch.domain.repository.IHabitRecordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import javax.inject.Inject

class HabitRecordRepositoryImpl @Inject constructor(
    private val dao: HabitRecordDao
) : IHabitRecordRepository {

    override fun getRecordsForHabit(habitId: Long): Flow<List<HabitRecord>> =
        dao.getRecordsForHabit(habitId).map { list -> list.map { it.toDomain() } }

    override suspend fun getRecordForDate(habitId: Long, date: LocalDate): HabitRecord? =
        dao.getRecordForDate(habitId, date.toString())?.toDomain()

    override suspend fun insert(record: HabitRecord) = dao.insert(record.toEntity())

    override suspend fun delete(id: Long) = dao.delete(id)
}
