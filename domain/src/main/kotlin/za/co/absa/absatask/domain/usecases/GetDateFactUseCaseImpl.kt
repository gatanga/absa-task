package za.co.absa.absatask.domain.usecases

import za.co.absa.absatask.data.repository.ApiRepository
import za.co.absa.absatask.data.result.FlowApiResult
import javax.inject.Inject

class GetDateFactUseCaseImpl @Inject constructor(private val repository: ApiRepository) :
    GetDateFactUseCase {

    override suspend fun getDateFact(month: String, day: String): String {
        var text = ""
        repository.getDateFact(month = month, day = day)
            .collect {
                when (it) {
                    is FlowApiResult.Success -> text = it.value.text
                    else -> (it as FlowApiResult.Error).exception.message
                }
            }

        return text
    }
}