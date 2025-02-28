package com.example.assignment.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment.R
import com.example.assignment.data.model.VitalsEntry
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun VitalsItem(
    vitalsEntry: VitalsEntry
) {
    ElevatedCard(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(1f)
                ){
                    VitalRow(R.drawable.heart_rate, "${vitalsEntry.heartRate} bpm")
                    VitalRow(R.drawable.scale, "${vitalsEntry.weight} kg")

                }
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(1f)
                ){
                    VitalRow(R.drawable.blood_pressure, "${vitalsEntry.systolicPressure}/${vitalsEntry.diastolicPressure} mmHg")
                    VitalRow(R.drawable.newborn, "${vitalsEntry.babyKicksCount}")
                }
            }
            Box(
                contentAlignment = Alignment.CenterEnd,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(10.dp)
            ){
                Text(
                    text = formatDate(vitalsEntry.timestamp),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Thin,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
            }
        }
    }
}

private fun formatDate(timestamp: Long): String {
    val dateFormat = SimpleDateFormat("MMM dd, yyyy • HH:mm", Locale.getDefault())
    return dateFormat.format(Date(timestamp))
}