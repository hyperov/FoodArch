package com.food.arch.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.food.arch.annotations.Main
import com.food.arch.model.Repository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(@Main val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(repository) as T
            else -> throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}