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
import com.example.app_catalogo_produto.domain.util.RemoteResult

// IMPORTS CORRIGIDOS:
// Você precisa importar o modelo de domínio (Product) e a interface do repositório (ProductRepository)
// para que o compilador entenda o que é retornado por ProductRepositoryImpl().getProducts()
import com.example.app_catalogo_produto.domain.model.Product
import com.example.app_catalogo_produto.domain.repository.ProductRepository
import com.example.app_catalogo_produto.data.repository.ProductRepositoryImpl
import com.example.app_catalogo_produto.ui.theme.App_Catalogo_ProdutoTheme

class MainActivity : ComponentActivity() {

    // A variável deve ser do tipo da interface ProductRepository, não da implementação concreta,
    // mas vamos manter o que estava no seu código original para evitar outros erros.
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
            // 1. O retorno é um RemoteResult<List<Product>>
            val result = repository.getProducts()

            // 2. Desempacotamos o resultado:
            statusText = when (result) {
                is RemoteResult.Success -> {
                    val products = result.data // Acesso à lista de produtos (List<Product>)

                    if (products.isNotEmpty()) {
                        "Carregou ${products.size} produtos.\nPrimeiro: ${products[0].name}"
                    } else {
                        "Nenhum produto retornado."
                    }
                }
                is RemoteResult.Error -> {
                    // Se for um erro, mostramos a mensagem que você definiu no repositório
                    "Erro ao carregar: ${result.message}"
                }
                // Adicione outros estados se RemoteResult tiver Loading, etc.
                else -> "Estado inesperado do resultado."
            }

        } catch (e: Exception) {
            statusText = "Erro fatal na coroutine: ${e.message}"
        }
    }


}


