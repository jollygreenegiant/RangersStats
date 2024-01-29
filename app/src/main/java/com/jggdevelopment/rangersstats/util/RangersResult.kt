package com.jggdevelopment.rangersstats.util

import android.util.Log
import androidx.compose.runtime.Composable

sealed interface RangersResult<out T> {
    data class Success<T>(val data: T) : RangersResult<T>
    data class Error(val exception: Throwable? = null) : RangersResult<Nothing>
    data object Loading : RangersResult<Nothing>

    val isSuccess: Boolean
        get() = this is Success

    val isError: Boolean
        get() = this is Error

    fun handle(
        onSuccess: (T) -> Unit = {},
        onError: (Throwable?) -> Unit = {},
        onLoading: () -> Unit = {}
    ) {
        when (this) {
            is Success -> onSuccess(data)
            is Error -> onError(exception)
            is Loading -> onLoading()
        }
    }

    @Composable
    fun handleUi(
        onSuccess: @Composable (T) -> Unit = {},
        onError: @Composable (Throwable?) -> Unit = {},
        onLoading: @Composable () -> Unit = {}
    ) {
        when (this) {
            is Success -> onSuccess(data)
            is Error -> onError(exception)
            is Loading -> onLoading()
        }
    }
}

@Suppress("TooGenericExceptionCaught", "FunctionNaming")
inline fun <T> RangersResult(block: () -> T): RangersResult<T> = try {
    RangersResult.Success(block())
} catch (e: Exception) {
    Log.e("ApiError", e.message.toString())
    RangersResult.Error(e)
}
