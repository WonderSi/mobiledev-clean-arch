package com.example.mobiledev_clean_arch.data.local.dao

import androidx.room.*
import com.example.mobiledev_clean_arch.data.local.entity.HabitRecordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitRecordDao {
    @Query("SELECT * FROM habit_records WHERE habitId = :habitId")
    fun getRecordsForHabit(habitId: Long): Flow<List<HabitRecordEntity>>

    @Query("SELECT * FROM habit_records WHERE habitId = :habitId AND completedAt = :date LIMIT 1")
    suspend fun getRecordForDate(habitId: Long, date: String): HabitRecordEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(record: HabitRecordEntity)

    @Query("DELETE FROM habit_records WHERE id = :id")
    suspend fun delete(id: Long)
}
