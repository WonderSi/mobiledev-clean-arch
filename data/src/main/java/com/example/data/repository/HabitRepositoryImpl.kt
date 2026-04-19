package com.example.data.repository

import com.example.data.local.dao.HabitDao
import com.example.data.mapper.toDomain
import com.example.data.mapper.toEntity
import com.example.domain.model.Habit
import com.example.domain.repository.IHabitRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HabitRepositoryImpl @Inject constructor(
    private val dao: HabitDao
) : IHabitRepository {
    override fun getAll(): Flow<List<Habit>> = dao.getAll().map { it.map { e -> e.toDomain() } }
    override suspend fun getById(id: Long): Habit? = dao.getById(id)?.toDomain()
    override suspend fun insert(habit: Habit): Long = dao.insert(habit.toEntity())
    override suspend fun update(habit: Habit) = dao.update(habit.toEntity())
    override suspend fun delete(id: Long) = dao.delete(id)
}
