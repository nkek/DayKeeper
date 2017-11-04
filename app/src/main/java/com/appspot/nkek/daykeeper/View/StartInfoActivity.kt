package com.appspot.nkek.daykeeper.View

import android.app.Activity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.appspot.nkek.daykeeper.R

/**
 * Created by nkek on 2017. 11. 5..
 */
class StartInfoActivity: Activity() {

    var pager:ViewPager ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startinfo)
    }
}