package com.example.app_catalogo_produto.domain.repository

import com.example.app_catalogo_produto.domain.model.Product

interface ProductRepository {
    suspend fun getProducts(): List<Product>
    suspend fun getProductById(id: Int): Product
}
