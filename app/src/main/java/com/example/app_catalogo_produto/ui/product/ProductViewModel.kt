package com.example.app_catalogo_produto.ui.product

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_catalogo_produto.data.repository.ProductRepositoryImpl
import com.example.app_catalogo_produto.domain.repository.ProductRepository
import com.example.app_catalogo_produto.domain.util.RemoteResult
import kotlinx.coroutines.launch

class ProductViewModel(
    private val repository: ProductRepository = ProductRepositoryImpl()
) : ViewModel() {


    var uiState by mutableStateOf<ProductUiState>(ProductUiState.Loading)
        private set

    init {
        loadProducts()
    }

    fun loadProducts() {
        viewModelScope.launch {
            uiState = ProductUiState.Loading

            val result = repository.getProducts()


            uiState = when (result) {
                is RemoteResult.Success -> {
                    val products = result.data
                    if (products.isNotEmpty()) {
                        ProductUiState.Success(products)
                    } else {
                        ProductUiState.Error("Nenhum produto encontrado.")
                    }
                }
                is RemoteResult.Error -> {

                    ProductUiState.Error(result.message)
                }

                RemoteResult.Loading -> ProductUiState.Loading
            }
        }
    }
}