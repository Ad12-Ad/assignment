package com.example.assignment.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class VitalsEntry(
    val systolicPressure: Int,
    val diastolicPressure: Int,
    val heartRate: Int,
    val weight: Float,
    val babyKicksCount: Int,
    val timestamp: Long = System.currentTimeMillis(),
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
