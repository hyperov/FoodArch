package com.food.arch.model

import com.food.arch.model.response.Employee
import io.reactivex.Flowable

interface Repository {

    var isNetworkConnected: Boolean

    fun getEmployees(): Flowable<List<Employee>>

    fun saveEmployees(vararg employee: Employee): List<Long>
}