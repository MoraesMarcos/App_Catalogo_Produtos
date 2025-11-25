package com.example.app_catalogo_produto.domain.model

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val image: String?,
    val category: String?
)
