package com.wen.learnandroid.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        back1()
    }

    /**
     * 线程名字
     */
    private fun back1() {
        GlobalScope.launch {
            Log.d(TAG, "GlobalScope default thread name ${Thread.currentThread().name}")
        }
        thread {
            Log.d(TAG, "Common thread name ${Thread.currentThread().name}")
        }
    }

    companion object {
        const val TAG = "Coroutines"
    }
}

