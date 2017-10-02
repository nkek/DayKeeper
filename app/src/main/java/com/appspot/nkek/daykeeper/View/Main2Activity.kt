package com.appspot.nkek.daykeeper.View

import android.app.Activity
import android.os.Bundle
import com.appspot.nkek.daykeeper.Model.DailyDiary
import com.appspot.nkek.daykeeper.R

class Main2Activity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var diary:DailyDiary = DailyDiary(0, "","", 999000098)
    }
}
