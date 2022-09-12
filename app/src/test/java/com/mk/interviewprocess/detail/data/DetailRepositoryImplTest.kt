package com.mk.interviewprocess.detail.data

import com.google.common.truth.Truth.assertThat
import com.mk.interviewprocess.detail.data.remote.DetailApi
import com.mk.interviewprocess.detail.data.remote.getPokemonDetailInvalid
import com.mk.interviewprocess.detail.data.remote.getPokemonDetailValid
import com.mk.interviewprocess.detail.domain.repository.DetailRepository
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

class DetailRepositoryImplTest {
    private lateinit var repository: DetailRepository
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
            .baseUrl(webServer.url("/")).build().create(DetailApi::class.java)
        repository = DetailRepositoryImpl(
            api = api
        )
    }

    @After
    fun tearDown() {
        webServer.shutdown()
    }

    @Test
    fun `get pokemon by id, valid response, returns success`() = runBlocking {
        webServer.enqueue(MockResponse().setBody(getPokemonDetailValid))
        val result = repository.getPokemonDetail(1)
        assertThat(result.isSuccess).isTrue()
        assertThat(result.getOrNull()?.name).isEqualTo("Bulbasaur")
    }

    @Test
    fun `get character by id, malformed response, returns failure`() = runBlocking {
        webServer.enqueue(MockResponse().setBody(getPokemonDetailInvalid))
        val result = repository.getPokemonDetail(1)
        assertThat(result.isFailure).isTrue()
        assertThat(result.getOrNull()).isNull()
    }
}
