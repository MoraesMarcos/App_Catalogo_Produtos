package com.example.app_catalogo_produto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.app_catalogo_produto.data.repository.ProductRepositoryImpl
import com.example.app_catalogo_produto.ui.theme.App_Catalogo_ProdutoTheme // ou o nome do seu tema

class MainActivity : ComponentActivity() {

    private val repository = ProductRepositoryImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App_Catalogo_ProdutoTheme {
                TestApiScreen(repository)
            }
        }
    }
}

@Composable
fun TestApiScreen(repository: ProductRepositoryImpl) {
    var statusText by remember { mutableStateOf("Carregando produtos...") }

    LaunchedEffect(Unit) {
        try {
            val products = repository.getProducts()
            statusText = if (products.isNotEmpty()) {
                "Carregou ${products.size} produtos.\nPrimeiro: ${products[0].name}"
            } else {
                "Nenhum produto retornado."
            }
        } catch (e: Exception) {
            statusText = "Erro ao carregar: ${e.message}"
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = statusText)
    }
}
