package za.co.absa.absatask.data.network.rest

import kotlinx.coroutines.Dispatchers
import za.co.absa.absatask.data.network.helper.ApiResponseWrapper
import za.co.absa.absatask.data.network.helper.safeApiCall
import za.co.absa.absatask.models.DateResponse
import za.co.absa.absatask.models.TriviaResponse
import javax.inject.Inject

class AbsaApiManager @Inject constructor(
    private val retrofitService: RetrofitService
) : ApiManager {

    private val dispatcher = Dispatchers.IO

    override suspend fun getNumberFact(number: String): ApiResponseWrapper<TriviaResponse> =
        safeApiCall(dispatcher = dispatcher) {
            TriviaResponse(text = retrofitService.getNumberFact(number = number))
        }

    override suspend fun getDateFact(day: String, month: String): ApiResponseWrapper<DateResponse> =
        safeApiCall(dispatcher = dispatcher) {
            DateResponse(text = retrofitService.getDateFact(month = month, day = day))
        }
}