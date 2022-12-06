package za.co.absa.absatask.domain.usecases

import za.co.absa.absatask.data.repository.ApiRepository
import za.co.absa.absatask.data.result.FlowApiResult
import javax.inject.Inject

class GetTriviaFactUseCaseImpl @Inject constructor(private val repository: ApiRepository) :
    GetTriviaFactUseCase {

    override suspend fun getTriviaFact(number: String): String {
        var text = ""
        repository.getNumberFact(number = number)
            .collect {
                when (it) {
                    is FlowApiResult.Success -> text = it.value.text
                    else -> (it as FlowApiResult.Error).exception.message
                }
            }

        return text
    }
}