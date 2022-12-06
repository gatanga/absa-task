package za.co.absa.absatask.data.network.rest

import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("{number}/trivia")
    suspend fun getNumberFact(@Path("number") number: String): String

    @GET("{month}/{day}/date")
    suspend fun getDateFact(@Path("month") month: String, @Path("day") day: String): String
}