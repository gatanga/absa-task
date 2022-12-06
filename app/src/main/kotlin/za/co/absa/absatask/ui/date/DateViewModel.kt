package za.co.absa.absatask.ui.date

import dagger.hilt.android.lifecycle.HiltViewModel
import za.co.absa.absatask.domain.usecases.GetDateFactUseCase
import za.co.absa.absatask.ui.base.BaseViewModel
import za.co.absa.absatask.ui.state.DataState

@HiltViewModel
class DateViewModel @javax.inject.Inject constructor(
    private val getDateFactUseCase: GetDateFactUseCase
) : BaseViewModel<DataState<Any>>() {

    override fun onStartObserve() {
        //Initialize stuff here. Currently none
    }

    fun getDateFact(month: String, day: String) {
        doAsync {
            postValue(DataState.Loading)
            val result = getDateFactUseCase.getDateFact(month = month, day = day)
            postValue(DataState.Success(result))
        }
    }
}