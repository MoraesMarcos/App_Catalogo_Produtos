package com.example.app_catalogo_produto.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.app_catalogo_produto.ui.product.ProductViewModel
import com.example.app_catalogo_produto.ui.product.ProductUiState
import androidx.compose.material3.Text
import com.example.app_catalogo_produto.domain.model.Product // Necessário para a tela de lista de produtos, via UiState

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "productList"
    ) {


        composable("productList") {

            val viewModel: ProductViewModel = viewModel()


            ProductListScreen(
                uiState = viewModel.uiState,

                onProductClick = { id ->
                    navController.navigate("productDetail/$id")
                }
            )
        }


        composable(
            route = "productDetail/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("productId") ?: 0


            ProductDetailScreen(productId = id)
        }
    }
}



@Composable
fun ProductDetailScreen(productId: Int) {
    Text(text = "Detalhes do Produto ID: $productId")
}


@Composable
fun ProductListScreen(
    uiState: ProductUiState,
    onProductClick: (Int) -> Unit
) {
    Text(text = "Tela de Lista esperando UI da Pessoa 1. Estado: ${uiState::class.simpleName}")
}