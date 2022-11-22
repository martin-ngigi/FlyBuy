package com.example.flybuy.domain.usecase

import com.example.flybuy.data.model.modelresponse.ProductItem
import com.example.flybuy.data.util.Resource
import com.example.flybuy.domain.repository.FlyBuyRepository
import javax.inject.Inject

class ProductUseCase @Inject constructor(
    private val flyBuyRepository: FlyBuyRepository
) {

    suspend fun getAllProducts(userToken: String) : Resource<ProductItem> {
        return flyBuyRepository.getAllProducts(userToken = userToken)
    }


}