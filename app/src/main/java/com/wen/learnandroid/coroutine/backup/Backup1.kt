package com.wen.learnandroid.coroutine.backup

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

/**
 * Description: 协程简单用法
 *
 * @author zengbowen
 */
class Backup1 {

    /**
     * 1.协程代码怎么写
     */
    fun back1() {
        GlobalScope.launch {
            println("Coroutines thread name ${Thread.currentThread().name}")
        }
    }

    /**
     * 2.协程的写法更简单吗
     */
    fun back2() {
        GlobalScope.launch {
            println("Coroutines thread name ${Thread.currentThread().name}")
        }
        thread {
            println("thread name ${Thread.currentThread().name}")
        }
    }
}
