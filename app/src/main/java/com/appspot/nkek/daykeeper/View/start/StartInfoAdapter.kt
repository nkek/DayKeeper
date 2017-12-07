package com.appspot.nkek.daykeeper.View.start

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.v4.view.PagerAdapter
import android.view.View
import android.os.Parcelable
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import com.appspot.nkek.daykeeper.R
import kotlinx.android.synthetic.main.layout_start_info.view.*

/**
 * Created by nkek on 2017. 11. 18..
 */
open class StartInfoAdapter(val context: Context,val list:List<Drawable>): PagerAdapter() {

    @SuppressLint("ResourceAsColor")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_start_info, container,false)!!

        val frame : FrameLayout = view.findViewById(R.id.backgroundLayout) as FrameLayout
        val backImage : ImageView = view.findViewById(R.id.backgroundImage) as ImageView
        backImage.setImageDrawable(list[position])
        when(position){
            0 -> {frame.setBackgroundColor(Color.rgb(100,208,186))}
            1 -> {frame.setBackgroundColor(Color.rgb(105,194,242))}
            2 -> {frame.setBackgroundColor(Color.rgb(102,202,183))}
            3 -> {frame.setBackgroundColor(Color.rgb(105,190,236))}
        }

        container.addView(view)
        return view
    }

    override fun isViewFromObject(view: View, Any: Any): Boolean {
        return view == Any
    }

    override fun restoreState(state: Parcelable?, loader: ClassLoader?) {}

    override fun saveState(): Parcelable? {
        return null
    }
    override fun destroyItem(container: ViewGroup, position: Int, any: Any) {
        container.removeView( any as View)
    }

    override fun getCount(): Int {
        return list!!.size
    }
}