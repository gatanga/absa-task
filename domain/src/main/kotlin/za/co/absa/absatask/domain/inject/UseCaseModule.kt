package za.co.absa.absatask.domain.inject

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import za.co.absa.absatask.domain.usecases.GetDateFactUseCase
import za.co.absa.absatask.domain.usecases.GetDateFactUseCaseImpl
import za.co.absa.absatask.domain.usecases.GetTriviaFactUseCase
import za.co.absa.absatask.domain.usecases.GetTriviaFactUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Singleton
    @Binds
    abstract fun bindGetTriviaFactUseCase(useCase: GetTriviaFactUseCaseImpl): GetTriviaFactUseCase

    @Singleton
    @Binds
    abstract fun bindGetDateFactUseCase(useCase: GetDateFactUseCaseImpl): GetDateFactUseCase
}