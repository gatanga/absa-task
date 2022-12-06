package za.co.absa.absatask.data.inject

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import za.co.absa.absatask.data.network.rest.AbsaApiManager
import za.co.absa.absatask.data.network.rest.ApiManager
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ApiModule {

    @Singleton
    @Binds
    abstract fun bindApiManager(apiManager: AbsaApiManager): ApiManager
}