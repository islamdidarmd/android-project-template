package com.example.androidprojecttemplate.data.datasource

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.androidprojecttemplate.di.apiModuleTest
import com.example.androidprojecttemplate.data.model.FindRepoByKeywordResponse
import com.example.androidprojecttemplate.data.network.GithubApiService
import com.example.androidprojecttemplate.di.dataSourceModuleTest
import com.example.androidprojecttemplate.di.dataModuleTest
import com.example.androidprojecttemplate.domain.core.Either
import io.mockk.coEvery
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import retrofit2.Response
import kotlin.test.assertIs

class GithubRemoteDataSourceTest : KoinTest {
    private val apiService by inject<GithubApiService>()
    private val remoteDataSource by inject<GithubRemoteDataSource>()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun start() {
        startKoin {
            modules(
                apiModuleTest,
                dataSourceModuleTest,
                dataModuleTest,
            )
        }
    }

    @Test
    fun `Remote datasource will return successful response`() {
        val repoListApiResponse by inject<FindRepoByKeywordResponse>()
        coEvery { apiService.findRepoByKeyword("keyword") } returns Response.success(
            repoListApiResponse
        )

        val result = runBlocking {
            return@runBlocking remoteDataSource.findRepoByKeyword("keyword")
        }
        assertIs<Either.Right<Exception, FindRepoByKeywordResponse>>(result)
    }

    @After
    fun tearUp() {
        stopKoin()
    }
}