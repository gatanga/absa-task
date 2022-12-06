package za.co.absa.absatask.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import za.co.absa.absatask.data.network.helper.ApiResponseWrapper
import za.co.absa.absatask.data.network.rest.ApiManager
import za.co.absa.absatask.data.result.FlowApiResult
import za.co.absa.absatask.models.DateResponse
import za.co.absa.absatask.models.TriviaResponse
import javax.inject.Inject

class AbsaApiRepository @Inject constructor(private val apiManager: ApiManager) : ApiRepository {

    private val dispatcher = Dispatchers.IO

    override suspend fun getNumberFact(number: String): Flow<FlowApiResult<TriviaResponse>> =
        flow {
            when (val response = apiManager.getNumberFact(number = number)) {
                is ApiResponseWrapper.Success -> emit(
                    FlowApiResult.Success(
                        response.value
                    )
                )
                is ApiResponseWrapper.NetworkError -> emit(
                    FlowApiResult.Error(
                        Exception(
                            NETWORK_ERROR
                        )
                    )
                )
                else -> emit(FlowApiResult.Error(Exception(GENERIC_ERROR)))
            }
        }.flowOn(dispatcher)


    override suspend fun getDateFact(day: String, month: String): Flow<FlowApiResult<DateResponse>> =
        flow {
            when (val response = apiManager.getDateFact(month = month, day = day)) {
                is ApiResponseWrapper.Success -> emit(
                    FlowApiResult.Success(
                        response.value
                    )
                )
                is ApiResponseWrapper.NetworkError -> emit(
                    FlowApiResult.Error(
                        Exception(
                            NETWORK_ERROR
                        )
                    )
                )
                else -> emit(FlowApiResult.Error(Exception(GENERIC_ERROR)))
            }
        }.flowOn(dispatcher)

    companion object {
        private const val NETWORK_ERROR = "Network error"
        private const val GENERIC_ERROR = "Generic error"
    }
}