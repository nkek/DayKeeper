package com.appspot.nkek.daykeeper.View

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.appspot.nkek.daykeeper.R


/**
 * Created by nkek on 2018. 2. 16..
 */
class DiaryListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return  inflater.inflate(R.layout.fragment_diary_list_layout, container, false)
    }
}