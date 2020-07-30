package com.wen.learnandroid.coroutine.backup

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

/**
 * Description: 协程泄漏
 *
 * @author zengbowen
 */
class Backup5 {
    val scope = MainScope()

    fun backup () {
        scope.launch{

        }
    }

    fun onDestroy() {
        scope.cancel()
    }
}
