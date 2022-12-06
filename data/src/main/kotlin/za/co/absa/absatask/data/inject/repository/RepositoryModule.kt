package za.co.absa.absatask.data.inject.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import za.co.absa.absatask.data.repository.AbsaApiRepository
import za.co.absa.absatask.data.repository.ApiRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindApiRepository(apiRepository: AbsaApiRepository): ApiRepository
}