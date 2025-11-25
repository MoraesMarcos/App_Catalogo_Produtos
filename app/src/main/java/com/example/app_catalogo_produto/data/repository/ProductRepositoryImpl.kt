package com.example.app_catalogo_produto.data.repository

import com.example.app_catalogo_produto.data.remote.ApiClient
import com.example.app_catalogo_produto.data.remote.mapper.toDomain
import com.example.app_catalogo_produto.domain.model.Product
import com.example.app_catalogo_produto.domain.repository.ProductRepository

class ProductRepositoryImpl : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        return try {
            ApiClient.productApi.getProducts().map { it.toDomain() }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getProductById(id: Int): Product {
        return ApiClient.productApi.getProductById(id).toDomain()
    }
}
