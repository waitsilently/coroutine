package com.wen.learnandroid.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

open class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 主线程名字
        Log.d(TAG, "Main ${Thread.currentThread().name}")

    }

    companion object {
        const val TAG = "Coroutines"
    }
}

