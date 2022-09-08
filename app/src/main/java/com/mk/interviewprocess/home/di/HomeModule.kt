package com.mk.interviewprocess.home.di

import com.mk.interviewprocess.home.data.remote.PokedexService
import com.mk.interviewprocess.home.data.repository.PokedexRepositoryImpl
import com.mk.interviewprocess.home.domain.repository.PokedexRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {
    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        ).build()
    }

    @Singleton
    @Provides
    fun provideApi(okHttpClient: OkHttpClient): PokedexService {
        return Retrofit.Builder().baseUrl(PokedexService.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient).build().create()
    }

    @Provides
    @Singleton
    fun provideRepository(api: PokedexService): PokedexRepository {
        return PokedexRepositoryImpl(api)
    }
}
