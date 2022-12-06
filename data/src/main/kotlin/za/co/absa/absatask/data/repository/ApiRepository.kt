package za.co.absa.absatask.data.repository

import kotlinx.coroutines.flow.Flow
import za.co.absa.absatask.data.result.FlowApiResult
import za.co.absa.absatask.models.DateResponse
import za.co.absa.absatask.models.TriviaResponse

interface ApiRepository {
    suspend fun getNumberFact(number: String): Flow<FlowApiResult<TriviaResponse>>

    suspend fun getDateFact(day: String, month: String): Flow<FlowApiResult<DateResponse>>
}