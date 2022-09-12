package com.mk.interviewprocess.home.data.repository

import com.google.common.truth.Truth.assertThat
import com.mk.interviewprocess.home.data.remote.HomeApi
import com.mk.interviewprocess.home.data.remote.getPokemonsInvalid
import com.mk.interviewprocess.home.data.remote.getPokemonsValid
import com.mk.interviewprocess.home.domain.repository.HomeRepository
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class HomeRepositoryImplTest {
    private lateinit var repository: HomeRepository
    private lateinit var webServer: MockWebServer

    @Before
    fun setUp() {
        webServer = MockWebServer()
        val okHttpClient = OkHttpClient.Builder()
            .writeTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .connectTimeout(1, TimeUnit.SECONDS)
            .build()
        val api = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(webServer.url("/")).build().create(HomeApi::class.java)
        repository = HomeRepositoryImpl(
            api = api
        )
    }

    @After
    fun tearDown() {
        webServer.shutdown()
    }

    @Test
    fun `get all pokemons, valid response, returns success`() = runBlocking {
        webServer.enqueue(MockResponse().setBody(getPokemonsValid))
        val result = repository.getPokemons()
        assertThat(result.isSuccess).isTrue()
        assertThat(result.getOrDefault(listOf()).size).isEqualTo(20)
    }

    @Test
    fun `get all pokemons, malformed response, returns failure`() = runBlocking {
        webServer.enqueue(MockResponse().setBody(getPokemonsInvalid))
        val result = repository.getPokemons()
        assertThat(result.isFailure).isTrue()
        assertThat(result.getOrNull()).isNull()
    }
}
