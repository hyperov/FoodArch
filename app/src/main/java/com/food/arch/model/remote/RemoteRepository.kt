package com.food.arch.model.remote

import com.food.arch.model.Repository
import com.food.arch.model.response.BaseResponse
import com.food.arch.model.response.Employee
import io.reactivex.Flowable
import javax.inject.Inject

class RemoteRepository @Inject constructor(val remoteNetwork: Apis) : Repository {
    override var isNetworkConnected: Boolean = false


    override fun getEmployees(): Flowable<List<Employee>> {
        return remoteNetwork.getEmployees().map { res: BaseResponse -> res.employees }
    }

    override fun saveEmployees(vararg employee: Employee): List<Long> {
        return emptyList()
    }
}