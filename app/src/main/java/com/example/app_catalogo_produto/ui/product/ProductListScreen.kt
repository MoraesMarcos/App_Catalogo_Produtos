package com.example.app_catalogo_produto.ui.product

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.app_catalogo_produto.domain.model.Product
import com.example.app_catalogo_produto.ui.state.ProductUiState
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun ProductListScreen(
    uiState: ProductUiState,
    onProductClick: (Int) -> Unit
) {
    when (uiState) {
        is ProductUiState.Loading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is ProductUiState.Error -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = uiState.message)
            }
        }
        is ProductUiState.Success -> {
            LazyColumn {
                items(uiState.products) { product ->
                    ProductItemCard(
                        product = product,
                        onClick = { onProductClick(product.id) }
                    )
                }
            }
        }
    }
}

@Composable
fun ProductItemCard(
    product: Product,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(text = product.name, style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(4.dp))
            Text(text = "R$ ${product.price}", style = MaterialTheme.typography.bodyMedium)

            product.category?.let {
                Spacer(Modifier.height(2.dp))
                Text(text = it, style = MaterialTheme.typography.labelSmall)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductListScreenPreview() {
    // Criando dados falsos só para ver como fica na tela
    val listaFalsa = listOf(
        Product(1, "Notebook Gamer", 4500.0, null, "Eletrônicos"),
        Product(2, "Mouse Sem Fio", 120.0, null, "Periféricos"),
        Product(3, "Cadeira de Escritório", 800.0, null, "Móveis")
    )

    // Mostrando a tela com os dados falsos
    ProductListScreen(
        uiState = ProductUiState.Success(listaFalsa),
        onProductClick = {}
    )
}