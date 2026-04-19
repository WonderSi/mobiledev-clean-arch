package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.dao.HabitDao
import com.example.data.local.dao.HabitRecordDao
import com.example.data.local.entity.HabitEntity
import com.example.data.local.entity.HabitRecordEntity

@Database(entities = [HabitEntity::class, HabitRecordEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
    abstract fun habitRecordDao(): HabitRecordDao
}
