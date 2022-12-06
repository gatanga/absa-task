package za.co.absa.absatask.data.result

sealed class FlowApiResult<out R> {
    data class Success<out T>(val value: T) : FlowApiResult<T>()
    data class Error(val exception: Exception) : FlowApiResult<Nothing>()
}
