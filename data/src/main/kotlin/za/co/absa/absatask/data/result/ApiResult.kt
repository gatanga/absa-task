package za.co.absa.absatask.data.result

sealed class ApiResult<out R> {
    data class Success<out T>(val value: T) : ApiResult<T>()
    data class Error(val exception: Exception) : ApiResult<Nothing>()
}