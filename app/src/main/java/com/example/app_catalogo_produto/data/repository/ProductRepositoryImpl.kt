package com.example.app_catalogo_produto.data.repository

import android.util.Log
import com.example.app_catalogo_produto.data.remote.ApiClient
import com.example.app_catalogo_produto.data.remote.mapper.toDomain
import com.example.app_catalogo_produto.domain.model.Product
import com.example.app_catalogo_produto.domain.repository.ProductRepository
import com.example.app_catalogo_produto.domain.util.RemoteResult
import retrofit2.HttpException
import java.io.IOException

class ProductRepositoryImpl : ProductRepository {

    override suspend fun getProducts(): RemoteResult<List<Product>> {
        return try {
            val dtoList = ApiClient.productApi.getProducts()
            val products = dtoList.map { it.toDomain() }
            RemoteResult.Success(products)
        } catch (e: Exception) {
            handleException(e)
        }
    }

    override suspend fun getProductById(id: Int): RemoteResult<Product> {
        return try {
            val dto = ApiClient.productApi.getProductById(id)
            RemoteResult.Success(dto.toDomain())
        } catch (e: Exception) {
            handleException(e)
        }
    }

    private fun <T> handleException(e: Exception): RemoteResult<T> {
        Log.e("ProductRepositoryImpl", "Erro na chamada de API", e)

        val message = when (e) {
            is IOException -> "Falha de conexão. Verifique sua internet."
            is HttpException -> {
                val code = e.code()
                when {
                    code in 500..599 -> "Erro no servidor. Tente novamente mais tarde."
                    code == 404 -> "Recurso não encontrado."
                    else -> "Erro na requisição (código: $code)."
                }
            }
            else -> "Erro inesperado. Tente novamente."
        }

        return RemoteResult.Error(message, e)
    }
}
