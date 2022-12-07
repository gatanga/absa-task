package za.co.absa.absatask.ui.trivia

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import za.co.absa.absatask.domain.usecases.GetTriviaFactUseCase
import za.co.absa.absatask.ui.base.BaseViewModel
import za.co.absa.absatask.ui.state.DataState

@HiltViewModel
class TriviaViewModel @javax.inject.Inject constructor(
    private val getTriviaFactUseCase: GetTriviaFactUseCase,
) : BaseViewModel<DataState<Any>>() {

    fun getTriviaFact(number: String) {
        doAsync {
            runBlocking {
                postValue(DataState.Loading)
                val result = getTriviaFactUseCase.getTriviaFact(number = number)
                postValue(DataState.Success(result))
            }
        }
    }
}