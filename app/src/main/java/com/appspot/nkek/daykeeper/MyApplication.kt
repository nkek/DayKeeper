package com.appspot.nkek.daykeeper

import android.app.Application
import android.content.Context

/**
 * Created by nkek on 2017. 12. 7..
 */

class MyApplication : Application() {

    companion object {
        var context: Context? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}
