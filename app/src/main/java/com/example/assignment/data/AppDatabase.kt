package com.example.assignment.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [VitalsEntry::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract val dao: VitalsDao
}