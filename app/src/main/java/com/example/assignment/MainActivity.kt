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
import androidx.core.view.WindowCompat
import com.example.assignment.di.AppModule
import com.example.assignment.ui.screens.VitalsScreen
import com.example.assignment.ui.screens.viewmodel.VitalsEvent
import com.example.assignment.ui.screens.viewmodel.VitalsViewModel
import com.example.assignment.ui.theme.AssignmentTheme
import com.example.assignment.worker.VitalsReminderScheduler

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: VitalsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        VitalsReminderScheduler.scheduleReminder(this)

        viewModel = AppModule.provideVitalsViewModel(this)

        setContent {
            AssignmentTheme {
                Surface (
                    modifier = Modifier.systemBarsPadding()
                ){
                    val state by viewModel.state.collectAsState()

                    if (intent?.getBooleanExtra("SHOW_ADD_VITALS_DIALOG", false) == true) {
                        viewModel.onEvent(VitalsEvent.ShowDialog)
                        intent.removeExtra("SHOW_ADD_VITALS_DIALOG")
                    }

                    VitalsScreen(
                        state = state,
                        onEvent = viewModel::onEvent
                    )
                }
            }
        }
    }
}