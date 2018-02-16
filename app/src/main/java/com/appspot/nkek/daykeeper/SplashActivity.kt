package com.appspot.nkek.daykeeper

import android.app.Activity
import android.content.Intent

import android.os.Bundle

import android.os.Handler
import com.appspot.nkek.daykeeper.LocalDB.CYDPreference
import com.appspot.nkek.daykeeper.View.MainActivity
import com.appspot.nkek.daykeeper.View.NavigationDrawerActivity
import com.appspot.nkek.daykeeper.View.StartInfoActivity


class SplashActivity : Activity() {

    private var DELAY_MILLIS = 2500L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            if(CYDPreference.getInstance().checked){
                val mainIntent = Intent(this@SplashActivity, MainActivity::class.java)
                this@SplashActivity.startActivity(mainIntent)
            }else{
                val mainIntent = Intent(this@SplashActivity, StartInfoActivity::class.java)
                this@SplashActivity.startActivity(mainIntent)
            }
            this@SplashActivity.finish()
        }, DELAY_MILLIS)
    }
}
