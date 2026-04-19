package com.example.feature.habits.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.feature.habits.data.local.dao.HabitDao
import com.example.feature.habits.data.local.dao.HabitRecordDao
import com.example.feature.habits.data.local.entity.HabitEntity
import com.example.feature.habits.data.local.entity.HabitRecordEntity

@Database(entities = [HabitEntity::class, HabitRecordEntity::class], version = 1)
abstract class HabitsDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
    abstract fun habitRecordDao(): HabitRecordDao
}
