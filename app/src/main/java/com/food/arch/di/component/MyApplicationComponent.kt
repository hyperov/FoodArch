package com.food.arch.di.component

import android.content.Context
import com.food.arch.app.App
import com.food.arch.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        MyApplicationModule::class,
        ViewModelModule::class,
        DataBaseModule::class,
        NetworkModule::class,
        RepositoryModule::class]
)
interface MyApplicationComponent : AndroidInjector<App> {

    override fun inject(instance: App?)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(context: Context): Builder

        fun build(): MyApplicationComponent
    }
}