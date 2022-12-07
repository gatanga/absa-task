package za.co.absa.absatask.data

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import za.co.absa.absatask.data.network.rest.AbsaApiManager
import za.co.absa.absatask.data.network.rest.ApiManager
import za.co.absa.absatask.data.network.rest.RetrofitService

class AbsaApiManagerTest {

    private val retrofitService: RetrofitService = mock()
    private lateinit var apiManager: ApiManager

    @Test
    fun `GIVEN getNumberFact() is called, THEN verify that ApiManager calls getNumberFact() from retrofitService`() =
        runBlocking<Unit> {
            val number = "42"
            apiManager =
                AbsaApiManager(retrofitService = retrofitService)

            apiManager.getNumberFact(number = number)

            verify(retrofitService, times(1)).getNumberFact(number = number)
        }

    @Test
    fun `GIVEN getDateFact() is called, THEN verify that ApiManager calls getDateFact() from retrofitService`() =
        runBlocking<Unit> {
            val day = "12"
            val month = "7"
            apiManager =
                AbsaApiManager(retrofitService = retrofitService)

            apiManager.getDateFact(day = day, month = month)

            verify(retrofitService, times(1)).getDateFact(month = month, day = day)
        }
}