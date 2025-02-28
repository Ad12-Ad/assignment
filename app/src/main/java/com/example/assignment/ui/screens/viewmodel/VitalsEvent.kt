package com.example.assignment.ui.screens.viewmodel


sealed interface VitalsEvent {
    object SaveVitals: VitalsEvent
    data class SetSystolicPressure(val systolicPressure: String): VitalsEvent
    data class SetDiastolicPressure(val diastolicPressure: String): VitalsEvent
    data class SetHeartRate(val heartRate: String): VitalsEvent
    data class SetWeight(val weight: String): VitalsEvent
    data class SetBabyKicksCount(val babyKicksCount: String): VitalsEvent
    object ShowDialog: VitalsEvent
    object HideDialog: VitalsEvent
}