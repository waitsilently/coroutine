package com.wen.learnandroid.coroutine.base

import android.app.Application

/**
 * @author zengbowen
 */
class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        CrashHandler().init()
    }
}
