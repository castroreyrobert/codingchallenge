package com.example.codingchallenge.di

import android.content.Context
import androidx.room.Room
import com.example.codingchallenge.BuildConfig
import com.example.codingchallenge.data.api.LevelsApi
import com.example.codingchallenge.data.levels.LevelActivityDatabase
import com.example.codingchallenge.data.levels.LevelDatabase
import com.example.codingchallenge.data.levels.LevelLocalRepository
import com.example.codingchallenge.data.levels.getLevelActivityDatabase
import com.example.codingchallenge.data.levels.getLevelDatabase
import com.google.gson.GsonBuilder
import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val X_REQUESTED_WITH = "XMLHttpRequest"
        val CONTENT_TYPE = "application/json"
        val ACCEPT = "application/json"

        val builder = OkHttpClient.Builder().addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                .addHeader("X-Requested-With", X_REQUESTED_WITH)
                .addHeader("Content-Type", CONTENT_TYPE)
                .addHeader("Accept", ACCEPT)
                .method(original.method, original.body)
            val request = requestBuilder.build()
            chain.proceed(request)
        }

        builder.connectTimeout(200, TimeUnit.SECONDS)
        builder.readTimeout(200, TimeUnit.SECONDS)
        builder.writeTimeout(200, TimeUnit.SECONDS)
        val logging = HttpLoggingInterceptor()
        logging.level =
            if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE

        builder.addInterceptor(logging)

        return builder.build()
    }

    @Provides
    fun provideGSONConverterFactory(): GsonConverterFactory {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        return GsonConverterFactory
            .create(gson)
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {

        val baseUrl = BuildConfig.BASE_URL

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideBankApi(retrofit: Retrofit): LevelsApi = retrofit.create(LevelsApi::class.java)

    @Singleton
    @Provides
    fun provideLevelDatabase(@ApplicationContext context: Context): LevelDatabase =
        getLevelDatabase(context)

    @Singleton
    @Provides
    fun provideLevelActivityDatabase(@ApplicationContext context: Context): LevelActivityDatabase =
        getLevelActivityDatabase(context)


}