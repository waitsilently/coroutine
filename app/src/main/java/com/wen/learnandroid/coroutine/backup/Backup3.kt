package com.wen.learnandroid.coroutine.backup

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.wen.learnandroid.coroutine.MainActivity.Companion.TAG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

/**
 * Description: 协程的优点：方便线程的切换
 * 顺序执行以下代码：
 * 1.子线程运行 ioCode1；
 * 2.主线程运行 uiCode1；
 * 3.子线程运行 ioCode2；
 * 4.主线程运行 uiCode2；
 * 线程实现
 * 协程实现
 * @author zengbowen
 */
class Backup3: AppCompatActivity(){

    private fun ioCode1() {
        Log.d(TAG, "ioCode1 ${Thread.currentThread().name}")
    }

    private fun ioCode2() {
        Log.d(TAG, "ioCode2 ${Thread.currentThread().name}")
    }

    private fun uiCode1() {
        Log.d(TAG, "uiCode1 ${Thread.currentThread().name}")
    }

    private fun uiCode2() {
        Log.d(TAG, "uiCode2 ${Thread.currentThread().name}")
    }

    /**
     * 1.线程实现
     */
    private fun backup1() {
        thread {
            ioCode1()
            runOnUiThread {
                uiCode1()
                thread {
                    ioCode2()
                    runOnUiThread {
                        uiCode2()
                    }
                }
            }
        }
    }

    /**
     * 2.协程实现
     */
    private fun backup2() {
        // 在指定的线程组执行
        GlobalScope.launch {
            ioCode1()
            uiCode1()
            ioCode2()
            uiCode2()
        }
    }

    /**
     * 3.协程实现，运行在主线程
     */
    private fun backup3() {
        GlobalScope.launch(Dispatchers.Main) {
            ioCode1()
            uiCode1()
            ioCode2()
            uiCode2()
        }
    }
}


/**
 * 4.协程实现，子线程和主线程切换
 * suspend 只起标记作用，其本身不能切换线程, 需要在内部调用其他 suspend 函数来真正切换线程
 * 挂起函数只能在协程或者其他挂起函数中被调用
 */
class BackupIO {

    private suspend fun ioCode1() {
        withContext(Dispatchers.IO) {
            // 5.模拟耗时操作
//            Thread.sleep(1000)
            Log.d(TAG, "ioCode1 ${Thread.currentThread().name}")
        }
    }

    private suspend fun ioCode2() {
        withContext(Dispatchers.IO) {
            // 5.模拟耗时操作
//            Thread.sleep(1000)
            Log.d(TAG, "ioCode2 ${Thread.currentThread().name}")
        }
    }
}



