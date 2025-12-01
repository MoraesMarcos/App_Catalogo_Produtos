package com.example.app_catalogo_produto

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.app_catalogo_produto.domain.model.Product
import com.example.app_catalogo_produto.ui.product.ProductListScreen
import com.example.app_catalogo_produto.ui.state.ProductUiState
import com.example.app_catalogo_produto.ui.theme.App_Catalogo_ProdutoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App_Catalogo_ProdutoTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val listaParaEntrega = listOf(
                        Product(
                            id = 1,
                            name = "Notebook Gamer",
                            price = 4500.0,
                            image = "https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=500&auto=format&fit=crop&q=60",
                            category = "Eletrônicos"
                        ),
                        Product(
                            id = 2,
                            name = "Mouse Sem Fio",
                            price = 120.0,
                            image = "https://images.unsplash.com/photo-1527864550417-7fd91fc51a46?w=500&auto=format&fit=crop&q=60",
                            category = "Periféricos"
                        ),
                        Product(
                            id = 3,
                            name = "Cadeira Ergonômica",
                            price = 800.0,
                            image = "https://images.unsplash.com/photo-1592078615290-033ee584e267?w=500&auto=format&fit=crop&q=60",
                            category = "Móveis"
                        ),
                        Product(
                            id = 4,
                            name = "Smartphone Pro",
                            price = 3200.0,
                            image = null,
                            category = "Celulares"
                        )
                    )
                    ProductListScreen(
                        uiState = ProductUiState.Success(listaParaEntrega),
                        onProductClick = { id ->
                            Toast.makeText(this, "Clique no ID: $id", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}