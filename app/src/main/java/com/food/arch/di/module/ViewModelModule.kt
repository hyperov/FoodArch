package com.food.arch.di.module

import android.arch.lifecycle.ViewModelProvider
import com.food.arch.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}

