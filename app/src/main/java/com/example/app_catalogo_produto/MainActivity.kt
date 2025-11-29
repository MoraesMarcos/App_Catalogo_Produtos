package com.example.app_catalogo_produto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.app_catalogo_produto.ui.AppNavHost
import com.example.app_catalogo_produto.ui.theme.App_Catalogo_ProdutoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App_Catalogo_ProdutoTheme {

                AppNavHost()
            }
        }
    }
}
