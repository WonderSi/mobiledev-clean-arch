package com.example.mobiledev_clean_arch.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mobiledev_clean_arch.data.local.dao.HabitDao
import com.example.mobiledev_clean_arch.data.local.dao.HabitRecordDao
import com.example.mobiledev_clean_arch.data.local.entity.HabitEntity
import com.example.mobiledev_clean_arch.data.local.entity.HabitRecordEntity

@Database(entities = [HabitEntity::class, HabitRecordEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
    abstract fun habitRecordDao(): HabitRecordDao
}
