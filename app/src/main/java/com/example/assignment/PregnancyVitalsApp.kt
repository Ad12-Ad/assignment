package com.example.assignment

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.example.assignment.worker.VitalsNotificationService

class PregnancyVitalsApp : Application() {
    override fun onCreate() {
        super.onCreate()

        createNotificationChannel()

    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Vitals Reminders"
            val descriptionText = "Reminds the user to log pregnancy vitals"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(
                VitalsNotificationService.VITALS_CHANNEL_ID,
                name,
                importance
            ).apply {
                description = descriptionText
            }
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}