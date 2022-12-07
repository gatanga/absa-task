package za.co.absa.absatask.data

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import za.co.absa.absatask.data.network.helper.ApiResponseWrapper
import za.co.absa.absatask.data.network.rest.ApiManager
import za.co.absa.absatask.data.repository.AbsaApiRepository
import za.co.absa.absatask.data.repository.ApiRepository
import za.co.absa.absatask.models.DateResponse
import za.co.absa.absatask.models.TriviaResponse

class AbsaApiRepositoryTest {

    private val apiManager: ApiManager = mock()
    private lateinit var apiRepository: ApiRepository
    private val triviaResponse =
        "4 is the number of nucleobase types in DNA and RNA – adenine, guanine, cytosine, thymine (uracil in RNA)."
    private val dateResponse =
        "March 29th is the day in 1993 that Catherine Callbeck becomes premier of Prince Edward Island and the first woman to be elected in a general election as premier of a Canadian province."
    private val number = "4"
    private val month = "3"
    private val day = "29"

    /*@Test
    fun `GIVEN getNumberFact() is called, THEN verify getNumberFact() is called from AbsaApiManager`() =
        runBlocking<Unit> {
            apiRepository = AbsaApiRepository(apiManager)
            apiRepository.getNumberFact(number = number)

            verify(apiManager, times(1)).getNumberFact(number = number)
        }

    @Test
    fun `GIVEN getDateFact() is called, THEN verify getDateFact() is called from AbsaApiManager`() =
        runBlocking<Unit> {
            apiRepository = AbsaApiRepository(apiManager)
            apiRepository.getDateFact(month = month, day = day)

            verify(apiManager, times(1)).getDateFact(month = month, day = day)
        }

    @Test
    fun `GIVEN getNumberFact() is called, WHEN result is successful, THEN return successful wrapper`() =
        runBlocking {
            whenever(apiManager.getNumberFact(number = number)).thenReturn(
                ApiResponseWrapper.Success(TriviaResponse(text = triviaResponse))
            )

            apiRepository = AbsaApiRepository(apiManager)
            assertEquals(
                ApiResponseWrapper.Success(TriviaResponse(text = triviaResponse)),
                apiRepository.getNumberFact(number = number)
            )
        }

    @Test
    fun `GIVEN getDateFact() is called, WHEN result is successful, THEN return successful wrapper`() =
        runBlocking {
            whenever(apiManager.getDateFact(month = month, day = day)).thenReturn(
                ApiResponseWrapper.Success(DateResponse(text = dateResponse))
            )

            assertEquals(
                ApiResponseWrapper.Success(DateResponse(text = dateResponse)),
                apiRepository.getDateFact(month = month, day = day)
            )
        }*/
}