package com.appserba0797.app.ui.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.appserba0797.app.R

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
    }
    companion object{
       const val OPEN_NEWS = "open_news"
    }
}

