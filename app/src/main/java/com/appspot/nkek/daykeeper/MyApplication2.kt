package com.appspot.nkek.daykeeper

import android.app.Application
import android.content.Context


class MyApplication2 : Application() {
    override fun onCreate() {
        // TODO Auto-generated method stub
        super.onCreate()
        context = this
        //initImageLoader(this)
    }

//    private fun initImageLoader(myApplication: MyApplication) {
//        // TODO Auto-generated method stub
//        val options = DisplayImageOptions.Builder()
//                .showImageOnLoading(R.drawable.ic_stub)
//                .showImageForEmptyUri(R.drawable.ic_empty)
//                .showImageOnFail(R.drawable.ic_error)
//                .cacheInMemory(true)
//                .cacheOnDisc(true)
//                .considerExifParams(true)
//                .build()
//
//        val config = ImageLoaderConfiguration.Builder(context)
//                .threadPriority(Thread.NORM_PRIORITY - 2)
//                .denyCacheImageMultipleSizesInMemory()
//                .discCacheFileNameGenerator(Md5FileNameGenerator())
//                .tasksProcessingOrder(QueueProcessingType.LIFO)
//                .writeDebugLogs() // Remove for release app
//                .defaultDisplayImageOptions(options)
//                .build()
//        // Initialize ImageLoader with configuration.
//        ImageLoader.getInstance().init(config)
//    }

    companion object {
        var context: Context? = null
            private set
    }
}
