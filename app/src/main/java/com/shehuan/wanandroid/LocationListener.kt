package com.shehuan.wanandroid

import android.app.Activity
import android.util.Log
import androidx.lifecycle.*

class LocationListener() :DefaultLifecycleObserver{
    private  val TAG = "LocationListener"
    override fun onCreate(owner: LifecycleOwner) {
        Log.d(TAG, "onCreate: ")
    }

    override fun onStart(owner: LifecycleOwner) {
        Log.d(TAG, "onStart: ")
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.d(TAG, "onStop: ")
    }
}