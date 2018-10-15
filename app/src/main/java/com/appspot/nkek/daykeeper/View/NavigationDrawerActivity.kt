package com.appspot.nkek.daykeeper.View

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Toast
import com.appspot.nkek.daykeeper.R


class NavigationDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var mFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        toolbar.title = ""

        val fab = findViewById(R.id.fab) as FloatingActionButton
        //  fab.setImageResource(R.drawable.main_icon_write);
//        fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_mode_edit_black_48dp));
//        fab.setPadding(0, 0, 0, 0)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
        onNavigationItemSelected(navigationView.menu.getItem(0))
        navigationView.menu.getItem(0).isChecked = true
    }

    override fun onBackPressed() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        when (id) {
            R.id.navUserInfo -> {
                mFragment = HomeFragment()
                Toast.makeText(this, "home", Toast.LENGTH_SHORT).show()
            }
            R.id.navUserDiary -> {
                mFragment = DiaryListFragment()
                Toast.makeText(this, "diary list", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
            else -> mFragment = HomeFragment()
        }

        if (mFragment != null) {
            val mFragmentManager = supportFragmentManager.beginTransaction()
            mFragmentManager.replace(R.id.content_fragment_layout, mFragment)
            mFragmentManager.commit()
        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
