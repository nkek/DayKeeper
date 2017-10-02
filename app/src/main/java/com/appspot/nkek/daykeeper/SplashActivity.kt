package com.appspot.nkek.daykeeper

import android.app.Activity
import android.content.Intent
import android.os.Bundle

import android.os.Handler


class SplashActivity : Activity() {

    private var DELAY_MILLIS = 2500L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(Runnable {
            val mainIntent = Intent(this@SplashActivity, MainActivity::class.java)
            this@SplashActivity.startActivity(mainIntent)
            this@SplashActivity.finish()
        }, DELAY_MILLIS)
    }
}
