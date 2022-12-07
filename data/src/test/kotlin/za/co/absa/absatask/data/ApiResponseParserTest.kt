package za.co.absa.absatask.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import retrofit2.HttpException
import retrofit2.Response
import za.co.absa.absatask.data.network.helper.ApiResponseWrapper
import za.co.absa.absatask.data.network.helper.safeApiCall
import java.io.IOException

class ApiResponseParserTest {

    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

    @Test
    fun `GIVEN an api call is made, WHEN an IOException occurs, THEN return a NetworkError ApiResponseWrapper`() =
        runBlocking {
            val actual = safeApiCall(dispatcher) { ioExceptionApiCall() }

            Assertions.assertTrue(actual is ApiResponseWrapper.NetworkError)
        }

    @Test
    fun `GIVEN an api call is made, WHEN an HttpException occurs, THEN return GenericError ApiResponseWrapper`() =
        runBlocking {
            val actual = safeApiCall(dispatcher) { httpExceptionApiCall() }
            val expected = ApiResponseWrapper.GenericError(500, "Something went wrong")

            assertEquals(expected, actual)
        }

    private fun ioExceptionApiCall(): ApiResponseWrapper<Throwable> {
        throw (IOException("Something went wrong"))
    }

    private fun httpExceptionApiCall(): Any {
        val responseBody = "".toResponseBody("application/json".toMediaTypeOrNull())
        val response = okhttp3.Response.Builder()
            .code(500)
            .request(Request.Builder().url("http://test-url/").build())
            .message("Something went wrong")
            .protocol(Protocol.HTTP_1_1)
            .build()

        throw HttpException(Response.error<Any>(responseBody, response))
    }
}