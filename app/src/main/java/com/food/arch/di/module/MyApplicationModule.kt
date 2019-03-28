package com.food.arch.di.module

import com.food.arch.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MyApplicationModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivityInjector(): MainActivity
}