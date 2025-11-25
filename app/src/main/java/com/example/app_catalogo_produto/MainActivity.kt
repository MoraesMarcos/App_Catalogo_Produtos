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
                    val listaFalsa = listOf(
                        Product(1, "Notebook Gamer", 4500.0, null, "Eletrônicos"),
                        Product(2, "Mouse Sem Fio", 120.0, null, "Periféricos"),
                        Product(3, "Cadeira de Escritório", 800.0, null, "Móveis"),
                        Product(4, "Teclado Mecânico", 250.0, null, "Periféricos"),
                        Product(5, "Monitor 24pol", 900.0, null, "Eletrônicos"),
                        Product(6, "Smartphone Top", 3200.0, null, "Celulares")
                    )
                    ProductListScreen(
                        uiState = ProductUiState.Success(listaFalsa),
                        onProductClick = { idProduto ->
                            Toast.makeText(this, "Você clicou no ID: $idProduto", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}