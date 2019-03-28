package com.food.arch.model

import com.food.arch.annotations.Local
import com.food.arch.annotations.Remote
import com.food.arch.model.response.Employee
import io.reactivex.Flowable
import javax.inject.Inject

class MainRepository @Inject constructor(
    @Local val localRepository: Repository,
    @Remote val remoteRepository: Repository
) : Repository {

    override var isNetworkConnected: Boolean = false

    override fun getEmployees(): Flowable<List<Employee>> {
        return if (isNetworkConnected) remoteRepository.getEmployees() else localRepository.getEmployees()
    }

    override fun saveEmployees(vararg employee: Employee): List<Long> {
        return localRepository.saveEmployees(*employee)
    }
}