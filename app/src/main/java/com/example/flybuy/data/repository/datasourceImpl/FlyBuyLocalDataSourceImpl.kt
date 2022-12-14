package com.example.flybuy.data.repository.datasourceImpl

import com.example.flybuy.data.db.FlyBuyDAO
import com.example.flybuy.data.model.modelresponse.ProductResponse
import com.example.flybuy.data.repository.datasource.FlyBuyLocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FlyBuyLocalDataSourceImpl @Inject constructor(
    private val flyBuyDAO: FlyBuyDAO
)  : FlyBuyLocalDataSource {

    override suspend fun addToWishlist(productResponse: ProductResponse) {
        return flyBuyDAO.addToWishlist(productResponse)
    }

    override fun getWishlistItems(): Flow<List<ProductResponse>> {
        return flyBuyDAO.wishlistItems()
    }

    override suspend fun deleteWishlistItem(productResponse: ProductResponse) {
        return flyBuyDAO.deleteWishlist(productResponse)
    }

    override suspend fun clearWishlist() {
        return flyBuyDAO.clearWishlist()
    }

}