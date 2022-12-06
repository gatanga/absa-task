package za.co.absa.absatask.data.network.rest

import za.co.absa.absatask.data.network.helper.ApiResponseWrapper
import za.co.absa.absatask.models.DateResponse
import za.co.absa.absatask.models.TriviaResponse

interface ApiManager {
    suspend fun getNumberFact(number: String): ApiResponseWrapper<TriviaResponse>

    suspend fun getDateFact(day: String, month: String): ApiResponseWrapper<DateResponse>
}