package com.food.arch.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.food.arch.model.local.EmployeesDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun getDatabase(context: Context): EmployeesDataBase {
        return Room.databaseBuilder(
            context,
            EmployeesDataBase::class.java, "database-employees"
        ).fallbackToDestructiveMigration().build()
    }
}