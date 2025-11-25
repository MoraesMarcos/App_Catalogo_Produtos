package com.example.app_catalogo_produto.ui.state

import com.example.app_catalogo_produto.domain.model.Product

sealed interface ProductUiState {
    data object Loading : ProductUiState
    data class Success(val products: List<Product>) : ProductUiState
    data class Error(val message: String) : ProductUiState
}