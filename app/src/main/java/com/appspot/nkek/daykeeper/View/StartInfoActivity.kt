package com.appspot.nkek.daykeeper.View

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.view.ViewPager
import android.view.View
import com.appspot.nkek.daykeeper.R
import com.appspot.nkek.daykeeper.View.start.StartInfoAdapter
import kotlinx.android.synthetic.main.activity_startinfo.*

/**
 * Created by nkek on 2017. 11. 5..
 */
class StartInfoActivity: Activity() {

    var pager:ViewPager ?= null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startinfo)

        introViewPager.adapter = StartInfoAdapter(this, listOf(getDrawable(R.drawable.intro_1),getDrawable(R.drawable.intro_2),getDrawable(R.drawable.intro_3),getDrawable(R.drawable.intro_4)))
        introViewPagerIndicator.setViewPager(introViewPager)
        introViewPagerIndicator.setOnPageChangeListener(getPagerSynchronizer(introViewPager))
    }

    private fun getPagerSynchronizer(vip: ViewPager): ViewPager.SimpleOnPageChangeListener{
        return object : ViewPager.SimpleOnPageChangeListener(){
            override fun onPageSelected(position: Int) {
                vip.setCurrentItem(position, true)
            }
        }
    }
}