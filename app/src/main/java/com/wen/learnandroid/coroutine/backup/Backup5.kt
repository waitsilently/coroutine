package com.wen.learnandroid.coroutine.backup

import kotlinx.coroutines.*

/**
 * Description: 协程泄漏
 *
 * @author zengbowen
 */
class Backup5 {
    val scope = MainScope()

    fun backup () {
        scope.launch{
            a()
            b()
            c()
        }
    }

    private suspend fun a() {
        delay(1000)
    }

    private suspend fun b() {
        withContext(Dispatchers.IO) {
            Thread.sleep(1000)
        }
    }

    private fun c() {

    }

    fun onDestroy() {
        scope.cancel()
    }
}
