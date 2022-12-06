package za.co.absa.absatask.domain.usecases

interface GetDateFactUseCase {
    suspend fun getDateFact(month: String, day: String): String
}