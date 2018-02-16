package com.appspot.nkek.daykeeper.View

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.appspot.nkek.daykeeper.R
import kotlinx.android.synthetic.main.fragment_diary_list_layout.view.*
import yalantis.com.sidemenu.interfaces.ScreenShotable


/**
 * Created by nkek on 2018. 2. 16..
 */
class DiaryListFragment : Fragment(), ScreenShotable {

    protected var res: Int = 0
    private var containerView: View? = null
    private var mBitmap: Bitmap? = null

    override fun getBitmap(): Bitmap {
        return mBitmap!!
    }

    override fun takeScreenShot() {
        val thread = object : Thread() {
            override fun run() {
                val bitmap = Bitmap.createBitmap(containerView!!.getWidth(),
                        containerView!!.getHeight(), Bitmap.Config.ARGB_8888)
                val canvas = Canvas(bitmap)
                containerView!!.draw(canvas)
                mBitmap = bitmap
            }
        }

        thread.start()
    }

    companion object {
        val CLOSE = "Close"
        val BUILDING = "Building"
        val BOOK = "Book"
        val PAINT = "Paint"
        val CASE = "Case"
        val SHOP = "Shop"
        val PARTY = "Party"
        val MOVIE = "Movie"

        fun newInstance(resId: Int): com.appspot.nkek.daykeeper.View.DiaryListFragment {
            val contentFragment = DiaryListFragment()
            val bundle = Bundle()
            bundle.putInt(Int::class.java.name, resId)
            contentFragment.arguments = bundle
            return contentFragment
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        res = arguments.getInt(Int::class.java.name)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var rootView: View = inflater.inflate(R.layout.fragment_diary_list_layout, container, false)
       rootView.image_content.setClickable(true)
        rootView.image_content.setFocusable(true)
        rootView.image_content.setImageResource(res)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.containerView = view.findViewById(R.id.mainContainer)
    }
}