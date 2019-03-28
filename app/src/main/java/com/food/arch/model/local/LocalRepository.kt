package com.food.arch.model.local

import com.food.arch.model.Repository
import com.food.arch.model.response.Employee
import io.reactivex.Flowable
import javax.inject.Inject

class LocalRepository @Inject constructor(val dataBase: EmployeesDataBase) : Repository {
    override var isNetworkConnected: Boolean = false


    override fun getEmployees(): Flowable<List<Employee>> {
        return dataBase.employeeDao().getAllEmployees()
    }

    override fun saveEmployees(vararg employee: Employee): List<Long> {
        return dataBase.employeeDao().insertAllRecipes(*employee)
    }
}