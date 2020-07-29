package com.wen.learnandroid.coroutine.backup

import android.util.Log
import com.wen.learnandroid.coroutine.MainActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

/**
 * Description: 协程与线程相比写法更简单吗
 *
 * @author zengbowen
 */
class Backup2 {
    fun backup() {
        // 协程
        GlobalScope.launch {
            Log.d(MainActivity.TAG, "GlobalScope ${Thread.currentThread().name}")
        }

        // 线程
        Thread {
            Log.d(MainActivity.TAG, "Common ${Thread.currentThread().name}")
        }.start()

        // 扩展函数
        thread {
            Log.d(MainActivity.TAG, "Extension ${Thread.currentThread().name}")
        }
    }
}
