package com.example.a90slemanswinner

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CarsPage : AppCompatActivity() {
    private lateinit var carsName: TextView
    private lateinit var Years: TextView
    private lateinit var Detail: TextView
    private lateinit var ImageViewCars : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cars_page)

        val dataCars = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Cars>("key_car", Cars::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Cars>("key_car")
        }

        carsName = findViewById(R.id.cars)
        Years = findViewById(R.id.year)
        Detail = findViewById(R.id.detail)
        ImageViewCars = findViewById(R.id.imgview)
        carsName.text = dataCars?.name.toString()
        Years.text = dataCars?.year.toString()
        Detail.text = dataCars?.content.toString()
        Glide.with(this)
            .load(dataCars?.image).into(ImageViewCars)


    }
}