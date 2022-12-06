package za.co.absa.absatask.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel<T> : ViewModel() {

    private val mutableLiveData: MutableLiveData<T> by lazy {
        MutableLiveData<T>().also {
            onStartObserve()
        }
    }

    val liveData: LiveData<T> get() = mutableLiveData
    private val dispatcher = Dispatchers.IO

    protected open fun onStartObserve() {}

    fun doAsync(function: suspend () -> (Unit)) {
        viewModelScope.launch {
            withContext(dispatcher) {
                function.invoke()
            }
        }
    }

    fun postValue(value: T) {
        mutableLiveData.postValue(value)
    }
}