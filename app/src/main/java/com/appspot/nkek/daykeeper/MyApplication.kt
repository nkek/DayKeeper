package com.appspot.nkek.daykeeper

import android.app.Application
import android.content.Context

/**
 * Created by nkek on 2017. 11. 5..
 */
internal class MyApplication: Application() {
    private var context: Context ?= null
    override fun onCreate() {
        super.onCreate()
        context = this
    }

    internal fun getContext() : Context? {
        return context
    }
}