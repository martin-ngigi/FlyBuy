package com.example.flybuy.presentation.di

import com.example.flybuy.data.repository.FlyBuyRepositoryImpl
import com.example.flybuy.data.repository.datasource.FlyBuyLocalDataSource
import com.example.flybuy.data.repository.datasource.FlyBuyRemoteDataSource
import com.example.flybuy.domain.repository.FlyBuyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providesFlyBuyRepository(
        flyBuyRemoteDataSource: FlyBuyRemoteDataSource,
        flyBuyLocalDataSource: FlyBuyLocalDataSource
    ): FlyBuyRepository {
        return FlyBuyRepositoryImpl(
            flyBuyRemoteDataSource = flyBuyRemoteDataSource,
            flyBuyLocalDataSource = flyBuyLocalDataSource
        )
    }
}