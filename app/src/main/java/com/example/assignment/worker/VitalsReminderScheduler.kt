package com.example.assignment.worker

import android.content.Context
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

object VitalsReminderScheduler {
    private const val WORK_NAME = "vitals_reminder_work"

    fun scheduleReminder(context: Context) {
        val constraints = Constraints.Builder()
            .setRequiresBatteryNotLow(true)
            .build()

        val reminderRequest = PeriodicWorkRequestBuilder<VitalsReminderWorker>(
            15, TimeUnit.MINUTES  // This is the minimum interval for PeriodicWorkRequest
        ).setConstraints(constraints)
            .build()

        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            WORK_NAME,
            ExistingPeriodicWorkPolicy.UPDATE, // Replace existing work if already scheduled
            reminderRequest
        )

        val immediateRequest = OneTimeWorkRequestBuilder<VitalsReminderWorker>().build()
        WorkManager.getInstance(context).enqueue(immediateRequest)
    }

//    fun cancelReminders(context: Context) {
//        WorkManager.getInstance(context).cancelUniqueWork(WORK_NAME)
//    }
}