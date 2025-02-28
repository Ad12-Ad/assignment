package com.example.assignment.di

import android.content.Context
import androidx.room.Room
import com.example.assignment.data.database.AppDatabase
import com.example.assignment.data.repository.VitalsRepository
import com.example.assignment.ui.screens.viewmodel.VitalsViewModel

object AppModule {
    private var database: AppDatabase? = null
    private var repository: VitalsRepository? = null
    private var viewModel: VitalsViewModel? = null

    fun provideDatabase(context: Context): AppDatabase {
        return database ?: synchronized(this) {
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "pregnancy_vitals_database"
            ).build().also { database = it }
        }
    }

    fun provideRepository(context: Context): VitalsRepository {
        return repository ?: synchronized(this) {
            VitalsRepository(provideDatabase(context).dao).also { repository = it }
        }
    }

    fun provideVitalsViewModel(context: Context): VitalsViewModel {
        return viewModel ?: synchronized(this) {
            VitalsViewModel(provideRepository(context)).also { viewModel = it }
        }
    }
}