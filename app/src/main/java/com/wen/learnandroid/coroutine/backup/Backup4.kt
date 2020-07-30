package com.wen.learnandroid.coroutine.backup

import android.util.Log
import com.wen.learnandroid.coroutine.MainActivity
import com.wen.learnandroid.coroutine.http.Api
import com.wen.learnandroid.coroutine.http.Repo
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.wen.learnandroid.coroutine.TAG

/**
 * Description: Retrofit 支持协程
 *
 * @author zengbowen
 */
class Backup4 {

    /**
     * 普通的 Retrofit 请求
     */
    private fun backup() {
        val retrofit = Retrofit.Builder().baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(Api::class.java)
        api.listRepos("waitsilently").enqueue(object : Callback<List<Repo>> {
            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }

            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                Log.d(TAG, "onResponse ${response.body()?.get(0)?.name}")
            }
        })
    }

    /**
     * 支持了协程的 Retrofit 请求
     */
    private fun backupWithCoroutine() {
        val retrofit = Retrofit.Builder().baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(Api::class.java)
        GlobalScope.launch(Dispatchers.Main) {
            val repos = api.listReposCoroutine("waitsilently")
            Log.d(TAG, "onResponse ${repos[0].name}")
        }
    }

    /**
     * 两个网络请求 A 和 B
     * 在两者都回来的时候去做操作
     * 需求：分别执行两次网络请求,然后把结果合并后展示到界面
     * 理论上：同时发起请求，但使用回调式的开发实际就会写成回调方式
     * 回调式开发比较困难
     */
    private fun asyncDemo() {
        val retrofit = Retrofit.Builder().baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(Api::class.java)

        GlobalScope.launch(Dispatchers.Main) {
            // 并行请求
            val first = async {
                api.listReposCoroutine("waitsilently")
            }
            val second = async {
                api.listReposCoroutine("waitsilently")
            }
            val same = first.await()[0].name == second.await()[0].name
            Log.d(TAG, "same = $same")
        }
    }
}
