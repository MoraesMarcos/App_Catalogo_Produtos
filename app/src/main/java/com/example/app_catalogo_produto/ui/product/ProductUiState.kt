package com.example.app_catalogo_produto.ui.product

import com.example.app_catalogo_produto.domain.model.Product

sealed class ProductUiState {

    object Loading : ProductUiState()


    data class Success(val products: List<Product>) : ProductUiState()


    data class Error(val message: String) : ProductUiState()
}