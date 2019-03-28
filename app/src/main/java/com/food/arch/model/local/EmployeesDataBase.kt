package com.food.arch.model.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.food.arch.model.response.Employee

@Database(entities = [Employee::class], version = 1, exportSchema = false)
abstract class EmployeesDataBase : RoomDatabase() {
    abstract fun employeeDao(): EmployeeDAO
}