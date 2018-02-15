package com.appspot.nkek.daykeeper.View.start

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Parcelable
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import com.appspot.nkek.daykeeper.LocalDB.CYDPreference
import com.appspot.nkek.daykeeper.R
import com.appspot.nkek.daykeeper.View.MainActivity
import com.appspot.nkek.daykeeper.View.NavigationKotlinActivity

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
            0 -> {
                frame.setBackgroundColor(Color.rgb(100,208,186))
            }
            1 -> {
                frame.setBackgroundColor(Color.rgb(105,194,242))
            }
            2 -> {
                view.findViewById(R.id.agreeButton).visibility = View.GONE
                view.findViewById(R.id.disagreeButton).visibility = View.GONE
                frame.setBackgroundColor(Color.rgb(102,202,183))
            }
            3 -> {
                view.findViewById(R.id.agreeButton).visibility = View.VISIBLE
                view.findViewById(R.id.disagreeButton).visibility = View.VISIBLE
                frame.setBackgroundColor(Color.rgb(105,194,242))
            }
        }

        view.findViewById(R.id.agreeButton).setOnClickListener{
            CYDPreference.getInstance().checked = true
            context.startActivity(Intent(context, NavigationKotlinActivity::class.java))
        }

        view.findViewById(R.id.disagreeButton).setOnClickListener{
            CYDPreference.getInstance().checked = false
            context.startActivity(Intent(context, MainActivity::class.java))
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