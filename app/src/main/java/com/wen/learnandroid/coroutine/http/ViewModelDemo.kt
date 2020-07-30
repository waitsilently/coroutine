package com.wen.learnandroid.coroutine.http

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Description: 协程和 ViewModel
 *
 * @author zengbowen
 */
class ViewModelDemo: ViewModel() {
    val repo = liveData {
        emit(load())
    }

    private suspend fun load(): List<Repo> {
        val retrofit = Retrofit.Builder().baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(Api::class.java)
        return api.listReposCoroutine("waitsilently")
    }
}
