package za.co.absa.absatask.ui.state

sealed class DataState<out R> {
    data class Success<out T>(val value: T) : DataState<T>()
    object Loading: DataState<Nothing>()
}