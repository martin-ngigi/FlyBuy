package com.example.flybuy.data.repository.datasource

import com.example.flybuy.data.model.modelrequest.LoginRequest
import com.example.flybuy.data.model.modelrequest.UserRequest
import com.example.flybuy.data.model.modelresponse.LoginResponse
import com.example.flybuy.data.model.modelresponse.ProductItem
import com.example.flybuy.data.model.modelresponse.ProductResponse
import com.example.flybuy.data.model.modelresponse.UserResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface FlyBuyRemoteDataSource {

	suspend fun loginUser(login : LoginRequest): Response<LoginResponse>
	suspend fun registerUser(user: UserRequest) : Response<UserResponse>
	suspend fun getAllProducts(userToken: String) : Response<ProductItem>
	suspend fun getProduct(itemId : Int) : Response<ProductResponse>

}