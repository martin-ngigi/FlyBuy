package com.example.flybuy.data.repository

import com.example.flybuy.data.model.modelrequest.LoginRequest
import com.example.flybuy.data.model.modelrequest.UserRequest
import com.example.flybuy.data.model.modelresponse.LoginResponse
import com.example.flybuy.data.model.modelresponse.ProductItem
import com.example.flybuy.data.model.modelresponse.ProductResponse
import com.example.flybuy.data.model.modelresponse.UserResponse
import com.example.flybuy.data.repository.datasource.FlyBuyLocalDataSource
import com.example.flybuy.data.repository.datasource.FlyBuyRemoteDataSource
import com.example.flybuy.data.util.Resource
import com.example.flybuy.domain.repository.FlyBuyRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class FlyBuyRepositoryImpl @Inject constructor(
	private val flyBuyRemoteDataSource: FlyBuyRemoteDataSource,
	private val flyBuyLocalDataSource: FlyBuyLocalDataSource
) : FlyBuyRepository {

	private fun responseToUserResult(response : Response<UserResponse>) : Resource<UserResponse>{
		if (response.isSuccessful){
			response.body()?.let { result->
				return Resource.Success(result)
			}
		}
		return Resource.Error(message = "${response.errorBody()?.string()}")
	}

	private fun responseToString(response: Response<LoginResponse>) : Resource<LoginResponse>{
		if (response.isSuccessful){
			response.body()?.let {
				return Resource.Success(it)
			}
		}
		return Resource.Error(message = "${response.errorBody()?.string()}")
	}

	private fun responseToShopItemResult(response: Response<ProductResponse>) : Resource<ProductResponse>{
		if (response.isSuccessful){
			response.body()?.let { result->
				return Resource.Success(result)
			}
		}
		return Resource.Error(message = "${response.errorBody()?.string()}")
	}

	private fun responseToShopResult(response: Response<ProductItem>) : Resource<ProductItem>{
		if (response.isSuccessful){
			response.body()?.let { result->
				return Resource.Success(result)
			}
		}
		return Resource.Error(message = "${response.errorBody()?.string()}")
	}

	override suspend fun loginUser(login: LoginRequest): Resource<LoginResponse> {
		return responseToString(flyBuyRemoteDataSource.loginUser(login = login))
	}

	override suspend fun registerUser(user: UserRequest): Resource<UserResponse> {
		return responseToUserResult(flyBuyRemoteDataSource.registerUser(user = user))
	}

	override suspend fun getAllProducts(userToken: String): Resource<ProductItem> {
		return responseToShopResult(flyBuyRemoteDataSource.getAllProducts(userToken = userToken))
	}

	override suspend fun getProduct(itemId: Int): Resource<ProductResponse> {
		return responseToShopItemResult(flyBuyRemoteDataSource.getProduct(itemId))
	}

	override suspend fun addToWishlist(productResponse: ProductResponse) {
		return flyBuyLocalDataSource.addToWishlist(productResponse)
	}

	override fun getWishlistItems(): Flow<List<ProductResponse>> {
		return flyBuyLocalDataSource.getWishlistItems()
	}

	override suspend fun deleteWishlistItem(productResponse: ProductResponse) {
		return flyBuyLocalDataSource.deleteWishlistItem(productResponse)
	}

	override suspend fun clearWishlist() {
		return flyBuyLocalDataSource.clearWishlist()
	}
}








