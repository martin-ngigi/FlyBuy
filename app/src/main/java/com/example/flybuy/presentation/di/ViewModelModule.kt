package com.example.flybuy.presentation.di

import android.app.Application
import com.example.flybuy.data.util.SharedPreference
import com.example.flybuy.domain.usecase.AuthUseCase
import com.example.flybuy.domain.usecase.ProductUseCase
import com.example.flybuy.presentation.viewmodel.HomeViewModel
import com.example.flybuy.presentation.viewmodel.LoginViewModel
import com.example.flybuy.presentation.viewmodel.SplashViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ViewModelModule {

	@Provides
	@Singleton
	fun providesLoginViewModel(authUseCase: AuthUseCase, sharedPreference: SharedPreference) : LoginViewModel{
		return LoginViewModel(authUseCase,sharedPreference)
	}

	@Singleton
	@Provides
	fun providesHomeViewModel(app : Application, productUseCase: ProductUseCase, sharedPreference: SharedPreference) : HomeViewModel {
		return HomeViewModel(app, productUseCase, sharedPreference)
	}

	@Singleton
	@Provides
	fun providesSplashViewModel(sharedPreference: SharedPreference) : SplashViewModel{
		return SplashViewModel(sharedPreference)
	}

}