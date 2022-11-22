package com.example.flybuy.presentation.di

import com.example.flybuy.data.api.FlyBuyApiService
import com.example.flybuy.data.db.FlyBuyDAO
import com.example.flybuy.data.repository.datasource.FlyBuyLocalDataSource
import com.example.flybuy.data.repository.datasource.FlyBuyRemoteDataSource
import com.example.flybuy.data.repository.datasourceImpl.FlyBuyLocalDataSourceImpl
import com.example.flybuy.data.repository.datasourceImpl.FlyBuyRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

	@Singleton
	@Provides
	fun providesFlyBuyLocalDataSource(flyBuyDAO: FlyBuyDAO) : FlyBuyLocalDataSource {
		return FlyBuyLocalDataSourceImpl(flyBuyDAO = flyBuyDAO)
	}

	@Provides
	@Singleton
	fun provideFlyBuyRemoteDataSource(flyBuyApiService: FlyBuyApiService): FlyBuyRemoteDataSource {
		return FlyBuyRemoteDataSourceImpl(flyBuyApiService = flyBuyApiService)
	}
}