package com.wen.learnandroid.coroutine.backup

import android.util.Log
import com.wen.learnandroid.coroutine.TAG
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

/**
 * Description: 协程代码怎么写
 *
 * @author zengbowen
 */
class Backup1 {
    fun backup() {
        GlobalScope.launch {
            Log.d(TAG, "GlobalScope  ${Thread.currentThread().name}")
        }
    }
}
