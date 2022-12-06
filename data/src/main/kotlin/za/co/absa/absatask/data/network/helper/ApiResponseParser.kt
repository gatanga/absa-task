package za.co.absa.absatask.data.network.helper

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T
): ApiResponseWrapper<T> {
    return withContext(dispatcher) {
        try {
            ApiResponseWrapper.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            Log.e(
                "safeApiCall error: ",
                if (throwable.message.isNullOrEmpty()) throwable.toString() else throwable.message!!
            )
            when (throwable) {
                is IOException -> {
                    ApiResponseWrapper.NetworkError
                }
                is HttpException -> {
                    val code = throwable.code()
                    val errorResponse = convertErrorBody(throwable)
                    ApiResponseWrapper.GenericError(code, errorResponse)
                }
                else -> {
                    ApiResponseWrapper.GenericError(null, throwable.message)
                }
            }
        }
    }
}

private fun convertErrorBody(throwable: HttpException): String? {
    return try {
        throwable.response()?.message()
    } catch (exception: Exception) {
        null
    }
}