package com.example.assignment.ui.viewmodel

import com.example.assignment.data.model.VitalsEntry


data class VitalsState(
    val vitalsEntries: List<VitalsEntry> = emptyList(),
    val systolicPressure: String = "",
    val diastolicPressure: String = "",
    val heartRate: String = "",
    val weight: String = "",
    val babyKicksCount: String = "",
    val isAddingVitals: Boolean = false,
)