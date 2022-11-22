package com.example.flybuy.domain.usecase

import android.util.Log
import com.example.flybuy.data.model.modelrequest.LoginRequest
import com.example.flybuy.data.model.modelrequest.UserRequest
import com.example.flybuy.data.model.modelresponse.LoginResponse
import com.example.flybuy.data.model.modelresponse.UserResponse
import com.example.flybuy.data.util.Resource
import com.example.flybuy.domain.repository.FlyBuyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AuthUseCase @Inject constructor(
	private val flyBuyRepository: FlyBuyRepository
) {
	fun loginUser(loginRequest: LoginRequest): Flow<Resource<LoginResponse>> = flow {
		emit(Resource.Loading())
		try {
			val response = flyBuyRepository.loginUser(login = loginRequest)
			Log.i("AuthUseCase", "I dey here, ${response.data?.token}")
			emit(response)

		} catch (e: HttpException) {
			Log.i("AuthUseCase", e.localizedMessage!!)
			emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
		} catch (e: IOException) {
			Log.i("AuthUseCase", e.localizedMessage!!)
			emit(Resource.Error("Couldn't reach server. Check your internet connection."))
		}
	}

	fun registerUser(userRequest: UserRequest) : Flow<Resource<UserResponse>> = flow {
		emit(Resource.Loading())
		//create a demo user and upload
		try {
			val response = flyBuyRepository.registerUser(user = userRequest)
			emit(response)
		}catch (e : HttpException){
			Log.i("AuthUseCase", e.localizedMessage!!)
			emit (Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
		}
		catch (e : IOException){
			Log.i("AuthUseCase", e.localizedMessage!!)
			emit (Resource.Error("Couldn't reach server. Check your internet connection."))
		}

	}

}