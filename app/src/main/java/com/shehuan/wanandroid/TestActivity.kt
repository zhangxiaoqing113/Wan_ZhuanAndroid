package com.shehuan.wanandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TestActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       lifecycle.addObserver(LocationListener())
    }
}