package com.example.app_catalogo_produto.domain.util

/**
 * Representa o resultado de uma chamada remota (API).
 * Pode ser Sucesso, Erro ou Carregando.
 */
sealed class RemoteResult<out T> {

    data class Success<T>(val data: T) : RemoteResult<T>()

    data class Error(
        val message: String,
        val throwable: Throwable? = null
    ) : RemoteResult<Nothing>()

    object Loading : RemoteResult<Nothing>()
}