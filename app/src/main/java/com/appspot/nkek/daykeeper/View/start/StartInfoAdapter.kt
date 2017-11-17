package com.appspot.nkek.daykeeper.View.start

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.os.Parcelable
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.ImageView
import com.appspot.nkek.daykeeper.R

/**
 * Created by nkek on 2017. 11. 18..
 */
class StartInfoAdapter(val context: Context,val list:List<String>): PagerAdapter() {

    override fun instantiateItem(view: ViewGroup, position: Int): Any {
        val imageLayout = LayoutInflater.from(context).inflate(R.layout.layout_start_info, view,false)!!

        val imageView = imageLayout!!
                .findViewById(R.id.image) as ImageView

       // imageView.setImageResource(list.get(position))

        view.addView(imageLayout, 0)

        return imageLayout
    }

    override fun isViewFromObject(view: View, Any: Any): Boolean {
        return view == Any
    }

    override fun restoreState(state: Parcelable?, loader: ClassLoader?) {}

    override fun saveState(): Parcelable? {
        return null
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return list!!.size
    }
}