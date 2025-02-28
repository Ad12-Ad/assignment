package com.example.assignment.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assignment.data.model.VitalsEntry
import kotlinx.coroutines.flow.Flow

@Dao
interface VitalsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertVitals(vitalsEntry: VitalsEntry)

    @Delete
    suspend fun deleteVitals(vitalsEntry: VitalsEntry)

    @Query("SELECT * FROM VitalsEntry ORDER BY timestamp DESC")
    fun getVitalsOrderedByTimestamp(): Flow<List<VitalsEntry>>

    @Query("SELECT * FROM VitalsEntry ORDER BY systolicPressure ASC")
    fun getVitalsOrderedByBloodPressure(): Flow<List<VitalsEntry>>

    @Query("SELECT * FROM VitalsEntry ORDER BY heartRate ASC")
    fun getVitalsOrderedByHeartRate(): Flow<List<VitalsEntry>>

    @Query("SELECT * FROM VitalsEntry ORDER BY weight ASC")
    fun getVitalsOrderedByWeight(): Flow<List<VitalsEntry>>

    @Query("SELECT * FROM VitalsEntry ORDER BY babyKicksCount DESC")
    fun getVitalsOrderedByKicks(): Flow<List<VitalsEntry>>
}