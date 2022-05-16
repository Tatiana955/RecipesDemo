package com.example.recipesdemo.di

import com.example.recipesdemo.data.EdamamRepository
import com.example.recipesdemo.data.EdamamRepositoryImpl
import com.example.recipesdemo.data.remote.EdamamApiService
import com.example.recipesdemo.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApi(): EdamamApiService {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofit.create(EdamamApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideEdamamRepository(api: EdamamApiService): EdamamRepository {
        return EdamamRepositoryImpl(api)
    }
}
