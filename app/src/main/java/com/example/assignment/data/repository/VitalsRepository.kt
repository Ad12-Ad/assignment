package com.example.assignment.data.repository

import com.example.assignment.data.database.VitalsDao
import com.example.assignment.data.model.VitalsEntry
import kotlinx.coroutines.flow.Flow

class VitalsRepository(
    private val dao: VitalsDao
) {
    suspend fun upsertVitals(vitalsEntry: VitalsEntry) {
        dao.upsertVitals(vitalsEntry)
    }

    fun getVitalsOrderedByTimestamp(): Flow<List<VitalsEntry>> {
        return dao.getVitalsOrderedByTimestamp()
    }
}