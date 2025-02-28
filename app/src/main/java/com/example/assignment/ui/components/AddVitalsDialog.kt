package com.example.assignment.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.assignment.ui.viewmodel.VitalsEvent
import com.example.assignment.ui.viewmodel.VitalsState

@Composable
fun AddVitalsDialog(
    state: VitalsState,
    onEvent: (VitalsEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
            onEvent(VitalsEvent.HideDialog)
        },
        title = {
            Text(
                text = "Add Vitals",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
        },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = state.systolicPressure,
                        onValueChange = {
                            onEvent(VitalsEvent.SetSystolicPressure(it))
                        },
                        placeholder = {
                            Text(text = "Sys BP")
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.weight(1f)
                    )

                    OutlinedTextField(
                        value = state.diastolicPressure,
                        onValueChange = {
                            onEvent(VitalsEvent.SetDiastolicPressure(it))
                        },
                        placeholder = {
                            Text(text = "Dia BP")
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = state.heartRate,
                    onValueChange = {
                        onEvent(VitalsEvent.SetHeartRate(it))
                    },
                    placeholder = {
                        Text(text = "Heart Rate in bpm")
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = state.weight,
                    onValueChange = {
                        onEvent(VitalsEvent.SetWeight(it))
                    },
                    placeholder = {
                        Text(text = "Weight in kg")
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = state.babyKicksCount,
                    onValueChange = {
                        onEvent(VitalsEvent.SetBabyKicksCount(it))
                    },
                    placeholder = {
                        Text(text = "Baby Kicks")
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    onEvent(VitalsEvent.SaveVitals)
                }, shape = RoundedCornerShape(10.dp)) {
                    Text(text = "Save Vitals")
                }
            }
        }
    )
}