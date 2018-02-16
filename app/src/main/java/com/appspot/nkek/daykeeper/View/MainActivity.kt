package com.appspot.nkek.daykeeper.View

import android.annotation.TargetApi
import android.app.Activity
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarActivity
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.AccelerateInterpolator
import android.widget.LinearLayout
import com.appspot.nkek.daykeeper.Model.DailyDiary
import com.appspot.nkek.daykeeper.R
import kotlinx.android.synthetic.main.activity_main.*
import yalantis.com.sidemenu.interfaces.Resourceble
import yalantis.com.sidemenu.interfaces.ScreenShotable
import yalantis.com.sidemenu.model.SlideMenuItem
import yalantis.com.sidemenu.util.ViewAnimator
import java.util.ArrayList

class MainActivity : ActionBarActivity(), ViewAnimator.ViewAnimatorListener {
    private var drawerLayout: DrawerLayout? = null
    private var drawerToggle: ActionBarDrawerToggle? = null
    private val list = ArrayList<SlideMenuItem>()
    private var contentFragment: DiaryListFragment? = null
    private var viewAnimator: ViewAnimator<*>? = null
    private var res = R.drawable.ic_menu_camera
    private var linearLayout: LinearLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        contentFragment = DiaryListFragment.newInstance(R.drawable.ic_menu_camera)
        supportFragmentManager.beginTransaction()
                .replace(R.id.content_frame, contentFragment)
                .commit()
        drawerLayout = findViewById(R.id.drawer_layout) as DrawerLayout
        drawerLayout!!.setScrimColor(Color.TRANSPARENT)
        linearLayout = findViewById(R.id.left_drawer) as LinearLayout
        linearLayout!!.setOnClickListener { drawerLayout!!.closeDrawers() }


        setActionBar()
        createMenuList()
        viewAnimator = ViewAnimator(this as ActionBarActivity, list, contentFragment, drawerLayout, this)
    }

    private fun createMenuList() {
        val menuItem0 = SlideMenuItem(DiaryListFragment.BOOK, R.drawable.ic_collections_bookmark_black_48dp)
        list.add(menuItem0)
        val menuItem = SlideMenuItem(DiaryListFragment.BUILDING, R.drawable.ic_account_circle_black_48dp)
        list.add(menuItem)
        val menuItem2 = SlideMenuItem(DiaryListFragment.BOOK, R.drawable.ic_book_black_48dp)
        list.add(menuItem2)
        val menuItem3 = SlideMenuItem(DiaryListFragment.PAINT, R.drawable.ic_assignment_ind_black_48dp)
        list.add(menuItem3)
        val menuItem4 = SlideMenuItem(DiaryListFragment.CASE, R.drawable.ic_account_balance_black_48dp)
        list.add(menuItem4)
        val menuItem5 = SlideMenuItem(DiaryListFragment.SHOP, R.drawable.ic_account_circle_black_48dp)
        list.add(menuItem5)
        val menuItem6 = SlideMenuItem(DiaryListFragment.PARTY, R.drawable.ic_account_circle_black_48dp)
        list.add(menuItem6)
        val menuItem7 = SlideMenuItem(DiaryListFragment.MOVIE, R.drawable.ic_account_circle_black_48dp)
        list.add(menuItem7)
    }


    private fun setActionBar() {
      //  setSupportActionBar(mainToolbar)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        drawerToggle = object : ActionBarDrawerToggle(
                this, /* host Activity */
                drawerLayout, /* DrawerLayout object */
                mainToolbar, /* nav drawer icon to replace 'Up' caret */
                R.string.app_name, /* "open drawer" description */
                R.string.app_name  /* "close drawer" description */
        ) {

            /** Called when a drawer has settled in a completely closed state.  */
            override fun onDrawerClosed(view: View?) {
                super.onDrawerClosed(view)
                linearLayout!!.removeAllViews()
                linearLayout!!.invalidate()
            }

            override fun onDrawerSlide(drawerView: View?, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                if (slideOffset > 0.6 && linearLayout!!.childCount == 0)
                    viewAnimator!!.showMenuContent()
            }

            /** Called when a drawer has settled in a completely open state.  */
            override fun onDrawerOpened(drawerView: View?) {
                super.onDrawerOpened(drawerView)
            }
        }
        drawerLayout!!.setDrawerListener(drawerToggle)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle!!.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        drawerToggle!!.onConfigurationChanged(newConfig)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (drawerToggle!!.onOptionsItemSelected(item)) {
            return true
        }
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun replaceFragment(screenShotable: ScreenShotable, topPosition: Int): ScreenShotable {
        this.res = if (this.res == R.drawable.ic_account_balance_black_48dp) R.drawable.ic_book_black_48dp else R.drawable.ic_assignment_ind_black_48dp
        val view = findViewById(R.id.content_frame)
        val finalRadius = Math.max(view.width, view.height)
        val animator = ViewAnimationUtils.createCircularReveal(view, 0, topPosition, 0f, finalRadius.toFloat())
        animator.setInterpolator(AccelerateInterpolator())
        animator.duration = ViewAnimator.CIRCULAR_REVEAL_ANIMATION_DURATION.toLong()

        findViewById(R.id.content_overlay).setBackgroundDrawable(BitmapDrawable(resources, screenShotable.bitmap))
        animator.start()
        val contentFragment = DiaryListFragment.newInstance(this.res)
        supportFragmentManager.beginTransaction().replace(R.id.content_frame, contentFragment).commit()
        return contentFragment
    }

    override fun onSwitch(slideMenuItem: Resourceble, screenShotable: ScreenShotable, position: Int): ScreenShotable {
        when (slideMenuItem.name) {
            DiaryListFragment.CLOSE -> return screenShotable
            else -> return replaceFragment(screenShotable, position)
        }
    }

    override fun disableHomeButton() {
        supportActionBar!!.setHomeButtonEnabled(false)

    }

    override fun enableHomeButton() {
        supportActionBar!!.setHomeButtonEnabled(true)
        drawerLayout!!.closeDrawers()

    }

    override fun addViewToContainer(view: View) {
        linearLayout!!.addView(view)
    }
}
