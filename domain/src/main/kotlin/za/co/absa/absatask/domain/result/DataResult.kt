package za.co.absa.absatask.domain.result

sealed class DataResult<out R> {
    data class Success<out T>(val value: T) : DataResult<T>()
    data class Error(val exception: Exception) : DataResult<Nothing>()
}
