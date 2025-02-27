package com.example.assignment.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.assignment.data.model.VitalsEntry

@Database(
    entities = [VitalsEntry::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract val dao: VitalsDao
}