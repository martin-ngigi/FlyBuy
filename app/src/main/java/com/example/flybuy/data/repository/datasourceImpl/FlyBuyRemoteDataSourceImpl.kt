package com.example.flybuy.data.repository.datasourceImpl

import com.example.flybuy.data.api.FlyBuyApiService
import com.example.flybuy.data.model.modelrequest.LoginRequest
import com.example.flybuy.data.model.modelrequest.UserRequest
import com.example.flybuy.data.model.modelresponse.LoginResponse
import com.example.flybuy.data.model.modelresponse.ProductItem
import com.example.flybuy.data.model.modelresponse.ProductResponse
import com.example.flybuy.data.model.modelresponse.UserResponse
import com.example.flybuy.data.repository.datasource.FlyBuyLocalDataSource
import com.example.flybuy.data.repository.datasource.FlyBuyRemoteDataSource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class FlyBuyRemoteDataSourceImpl @Inject constructor(
	private val flyBuyApiService: FlyBuyApiService
) : FlyBuyRemoteDataSource {

	override suspend fun loginUser(login: LoginRequest): Response<LoginResponse> {
		return flyBuyApiService.loginUser(login = login)
	}

	override suspend fun registerUser(user: UserRequest): Response<UserResponse> {
		return flyBuyApiService.registerUser(user = user)
	}

	override suspend fun getAllProducts(userToken: String): Response<ProductItem> {
		return flyBuyApiService.getProducts(userToken = userToken)
	}

	override suspend fun getProduct(itemId: Int): Response<ProductResponse> {
		return flyBuyApiService.getProduct(itemId = itemId)
	}

}