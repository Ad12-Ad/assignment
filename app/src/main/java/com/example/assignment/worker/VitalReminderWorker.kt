package com.example.assignment.worker


import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class VitalsReminderWorker(
    private val context: Context,
    workerParams: WorkerParameters
) : Worker(context, workerParams) {

    override fun doWork(): Result {
        val notificationService = VitalsNotificationService(context)
        notificationService.showNotification()
        return Result.success()
    }
}
