package com.example.a90slemanswinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val iv_back:ImageView = findViewById(R.id.iv_back)
        iv_back.setOnClickListener{
            finish()
        }
    }
}