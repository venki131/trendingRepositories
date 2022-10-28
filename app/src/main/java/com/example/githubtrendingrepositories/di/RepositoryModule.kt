package com.example.githubtrendingrepositories.di

import com.example.githubtrendingrepositories.data.repository.TrendingRepoRepositoryImpl
import com.example.githubtrendingrepositories.domain.repository.TrendingRepoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindTrendingRepository(
        trendingRepoRepositoryImpl: TrendingRepoRepositoryImpl
    ): TrendingRepoRepository
}