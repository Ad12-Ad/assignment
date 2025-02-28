package com.example.assignment.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment.data.database.VitalsDao
import com.example.assignment.data.model.VitalsEntry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class VitalsViewModel(
    private val dao: VitalsDao
): ViewModel() {

    private val _vitalsEntries = dao.getVitalsOrderedByTimestamp()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _state = MutableStateFlow(VitalsState())
    val state = combine(_state, _vitalsEntries) { state, vitals ->
        state.copy(
            vitalsEntries = vitals
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), VitalsState())

    fun onEvent(event: VitalsEvent) {
        when(event) {
            VitalsEvent.HideDialog -> {
                _state.update { it.copy(
                    isAddingVitals = false
                )}
            }
            VitalsEvent.SaveVitals -> {
                val systolicPressure = state.value.systolicPressure.toIntOrNull() ?: return
                val diastolicPressure = state.value.diastolicPressure.toIntOrNull() ?: return
                val heartRate = state.value.heartRate.toIntOrNull() ?: return
                val weight = state.value.weight.toFloatOrNull() ?: return
                val babyKicksCount = state.value.babyKicksCount.toIntOrNull() ?: return

                val vitalsEntry = VitalsEntry(
                    systolicPressure = systolicPressure,
                    diastolicPressure = diastolicPressure,
                    heartRate = heartRate,
                    weight = weight,
                    babyKicksCount = babyKicksCount
                )

                viewModelScope.launch {
                    dao.upsertVitals(vitalsEntry)
                }

                _state.update { it.copy(
                    isAddingVitals = false,
                    systolicPressure = "",
                    diastolicPressure = "",
                    heartRate = "",
                    weight = "",
                    babyKicksCount = ""
                )}
            }
            is VitalsEvent.SetSystolicPressure -> {
                _state.update { it.copy(
                    systolicPressure = event.systolicPressure
                )}
            }
            is VitalsEvent.SetDiastolicPressure -> {
                _state.update { it.copy(
                    diastolicPressure = event.diastolicPressure
                )}
            }
            is VitalsEvent.SetHeartRate -> {
                _state.update { it.copy(
                    heartRate = event.heartRate
                )}
            }
            is VitalsEvent.SetWeight -> {
                _state.update { it.copy(
                    weight = event.weight
                )}
            }
            is VitalsEvent.SetBabyKicksCount -> {
                _state.update { it.copy(
                    babyKicksCount = event.babyKicksCount
                )}
            }
            VitalsEvent.ShowDialog -> {
                _state.update { it.copy(
                    isAddingVitals = true
                )}
            }
        }
    }
}