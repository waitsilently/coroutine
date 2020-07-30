package com.wen.learnandroid.coroutine.http

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Description:
 *
 * @author zengbowen
 */
interface Api {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<List<Repo>>

    @GET("users/{user}/repos")
    suspend fun listReposCoroutine(@Path("user") user: String): List<Repo>
}
