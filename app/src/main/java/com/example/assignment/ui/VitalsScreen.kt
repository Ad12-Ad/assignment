package com.example.assignment.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment.R
import com.example.assignment.data.model.VitalsEntry
import com.example.assignment.ui.components.AddVitalsDialog
import com.example.assignment.ui.viewmodel.VitalsEvent
import com.example.assignment.ui.viewmodel.VitalsState
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun VitalsScreen(
    state: VitalsState,
    onEvent: (VitalsEvent) -> Unit
) {
    Scaffold(
        topBar = {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(horizontal = 12.dp, vertical = 20.dp)
            ) {
                Text(
                    text = "Pregnancy Vitals Tracker",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.primary
                    )
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onEvent(VitalsEvent.ShowDialog)
            }, shape = CircleShape) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Vitals"
                )
            }
        },
        modifier = Modifier
    ) { padding ->
        if (state.isAddingVitals) {
            AddVitalsDialog(state = state, onEvent = onEvent)
        }

        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (state.vitalsEntries.isEmpty()) {
                item {
                    Text(
                        text = "No vitals recorded yet. Tap the + button to add your first entry.",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Thin,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                        modifier = Modifier.padding( horizontal = 10.dp, vertical = 32.dp)
                    )
                }
            }
        }
    }
}