package com.mk.interviewprocess.detail.di

import com.mk.interviewprocess.detail.data.DetailRepositoryImpl
import com.mk.interviewprocess.detail.data.remote.DetailApi
import com.mk.interviewprocess.detail.domain.repository.DetailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DetailModule {
    @Singleton
    @Provides
    fun provideApi(okHttpClient: OkHttpClient): DetailApi {
        return Retrofit.Builder().baseUrl(DetailApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient).build().create()
    }

    @Provides
    @Singleton
    fun provideRepository(api: DetailApi): DetailRepository {
        return DetailRepositoryImpl(api)
    }
}
