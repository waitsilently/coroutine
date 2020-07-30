package com.wen.learnandroid.coroutine.backup

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Description:
 *
 * @author zengbowen
 */
class TestDemo {
    fun coroutineTest() {
        repeat(100000) {
            GlobalScope.launch() {
                delay(1000)
                println(".")
            }
        }
    }

    fun threadTest() {
        val executor = Executors.newSingleThreadScheduledExecutor()
        val task = Runnable {
            println(".")
        }
        repeat(100000) {
            executor.schedule(task, 1, TimeUnit.SECONDS)
        }
    }
}
