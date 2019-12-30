package com.maxtayler.punk.data.di

import com.maxtayler.punk.data.network.service.PunkApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class RetrofitModule {

    @Provides
    @Singleton
    internal fun provideApi() = provideRetrofit().create(PunkApiService::class.java)

    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(provideOkHttpClient())
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    private fun provideOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(provideOkHttpLogging()).build()

    private fun provideOkHttpLogging(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC
        return logging
    }

    companion object {
        private const val BASE_URL = "https://api.punkapi.com/v2/"
    }
}
