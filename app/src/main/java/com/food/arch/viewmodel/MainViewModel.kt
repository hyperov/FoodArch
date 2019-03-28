package com.food.arch.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.food.arch.model.Repository
import com.food.arch.model.response.Employee
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val repository: Repository) : ViewModel() {

    private var compositeDisposable = CompositeDisposable()

    val employeesLiveData = MutableLiveData<List<Employee>>()
    var networkLiveData = MutableLiveData<Boolean>()
    var errorLiveData = MutableLiveData<String>()
    var progressLiveData = MutableLiveData<Boolean>()

    fun getAllEmployees() {
        repository.isNetworkConnected = networkLiveData.value!!
        compositeDisposable.add(repository.getEmployees()
            .doFinally {
                Observable.fromCallable { repository.saveEmployees(*employeesLiveData.value?.toTypedArray()!!) }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ }, { t: Throwable? -> errorLiveData.value = t?.message })
            }
            .doOnNext { }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    employeesLiveData.value = it
                },
                { t: Throwable? ->
                    errorLiveData.value = t?.message
                }
            )
        )

    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}