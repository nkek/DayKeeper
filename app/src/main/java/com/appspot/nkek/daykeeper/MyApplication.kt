package com.appspot.nkek.daykeeper

import android.app.Application
import android.content.Context

/**
 * Created by nkek on 2017. 11. 18..
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        var context: Context? = null
            private set
    }
}