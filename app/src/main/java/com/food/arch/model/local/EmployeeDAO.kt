package com.food.arch.model.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.food.arch.model.response.Employee
import io.reactivex.Flowable

@Dao
interface EmployeeDAO {

    @Query("SELECT * FROM employees")
    fun getAllEmployees(): Flowable<List<Employee>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllRecipes(vararg employee: Employee): List<Long>


}