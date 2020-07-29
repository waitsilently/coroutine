package com.wen.learnandroid.coroutine.base

import android.util.Log
import kotlin.system.exitProcess

/**
 * Description: 捕获异常
 *
 * @author zengbowen
 */
class CrashHandler : Thread.UncaughtExceptionHandler {
    fun init() {
        Thread.setDefaultUncaughtExceptionHandler(this)
    }

    override fun uncaughtException(t: Thread, e: Throwable) {
        Log.e("Coroutines", e.message.orEmpty())
        exitProcess(0)
    }
}
