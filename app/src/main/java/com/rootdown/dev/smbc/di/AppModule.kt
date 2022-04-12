package com.rootdown.dev.smbc.di

import com.rootdown.dev.smbc.data.net.ApiService
import com.rootdown.dev.smbc.data.repo.SearchRecipeRepo
import com.rootdown.dev.smbc.data.repo.SearchRecipeRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSearchRepoImpl(
        service: ApiService,
    ) = SearchRecipeRepoImpl(service) as SearchRecipeRepo
}