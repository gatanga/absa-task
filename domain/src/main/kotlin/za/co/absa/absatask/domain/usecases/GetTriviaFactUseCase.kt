package za.co.absa.absatask.domain.usecases

interface GetTriviaFactUseCase {
    suspend fun getTriviaFact(number: String): String
}