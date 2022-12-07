package za.co.absa.absatask.data.inject

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import za.co.absa.absatask.data.R
import za.co.absa.absatask.data.network.rest.RetrofitService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofitService(
        httpClient: OkHttpClient,
        @ApplicationContext context: Context
    ): RetrofitService {
        return Retrofit.Builder()
            .client(httpClient)
            .baseUrl(context.getString(R.string.API_URL))
            .addConverterFactory(ScalarsConverterFactory.create())
            .build().create(RetrofitService::class.java)
    }

    private const val CONTENT_TYPE = "application/json"
}