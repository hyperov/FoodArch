package com.food.arch.di.module;

import com.food.arch.annotations.Local;
import com.food.arch.annotations.Main;
import com.food.arch.annotations.Remote;
import com.food.arch.model.MainRepository;
import com.food.arch.model.Repository;
import com.food.arch.model.local.LocalRepository;
import com.food.arch.model.remote.RemoteRepository;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by anabil on 10/21/2017.
 */

@Module
public class RepositoryModule {


    @Singleton
    @Local
    @Provides
    Repository provideTasksLocalDataSource(LocalRepository dataSource) {
        return dataSource;
    }

    @Singleton
    @Remote
    @Provides
    Repository provideTasksRemoteDataSource(RemoteRepository dataSource) {
        return dataSource;
    }

    @Singleton
    @Main
    @Provides
    Repository provideTasksMainDataSource(MainRepository dataSource) {
        return dataSource;
    }

}
