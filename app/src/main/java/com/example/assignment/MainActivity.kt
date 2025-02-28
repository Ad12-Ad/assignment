package com.example.assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.assignment.data.database.AppDatabase
import com.example.assignment.ui.screens.VitalsScreen
import com.example.assignment.ui.screens.viewmodel.VitalsViewModel
import com.example.assignment.ui.theme.AssignmentTheme

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: VitalsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize database
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "pregnancy_vitals_database"
        ).build()

        // Create ViewModel
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return VitalsViewModel(db.dao) as T
            }
        })[VitalsViewModel::class.java]

        setContent {
            AssignmentTheme {
                Surface (
                    modifier = Modifier.systemBarsPadding()
                ){
                    val state by viewModel.state.collectAsState()
                    VitalsScreen(
                        state = state,
                        onEvent = viewModel::onEvent
                    )
                }
            }
        }
    }
}
