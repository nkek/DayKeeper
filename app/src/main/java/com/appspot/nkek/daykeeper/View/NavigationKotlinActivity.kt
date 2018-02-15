package com.appspot.nkek.daykeeper.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.view.MenuItem
import android.widget.Toast
import com.appspot.nkek.daykeeper.R

class NavigationKotlinActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemReselectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_kotlin)
    }

    override fun onNavigationItemReselected(item: MenuItem) {
        val id = item.itemId

        if (id == R.id.navUserInfo) {
         //   mFragment = HomeFragment()
            Toast.makeText(this, "home2", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.navUserDiary) {
            Toast.makeText(this, "navUserDiary2", Toast.LENGTH_SHORT).show()
         //   mFragment = DiaryListFragment()
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

//        if (mFragment != null) {
//            val ft = supportFragmentManager.beginTransaction()
//            ft.replace(R.id.content_fragment_layout, mFragment)
//            ft.commit()
//        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
    }
}
