package com.appspot.nkek.daykeeper.LocalDB



import android.content.Context
import android.content.SharedPreferences
import com.appspot.nkek.daykeeper.MyApplication
import com.appspot.nkek.daykeeper.MyApplication2

class CYDPreference private constructor() {

    companion object {
        private val mInstance: CYDPreference = CYDPreference()
        @Synchronized
        fun getInstance(): CYDPreference {
            return mInstance
        }

        private val PREF_NAME = "NAME"
        private val KEY = "KEY"
    }

    private var mPrefs: SharedPreferences
    private var mEditor: SharedPreferences.Editor
    private var agreeIsChecked: Boolean? = null

    init {
        mPrefs = MyApplication2.context!!.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        mEditor = mPrefs.edit()
    }

    var checked: Boolean
        get() {
            if (agreeIsChecked == null) {
                agreeIsChecked = mPrefs.getBoolean(KEY, false)
            }
            return agreeIsChecked!!
        }
        set(isChecked) {
            agreeIsChecked = isChecked
            mEditor.putBoolean(KEY, agreeIsChecked!!)
            mEditor.commit()
        }


}
