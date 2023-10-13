package com.example.a90slemanswinner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var aboutFAB : FloatingActionButton
    private val carsList = ArrayList<Cars>()
    private lateinit var carsAdapter: CarsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view_cars)
        recyclerView.setHasFixedSize(true)
        carsList.addAll(getListCars())
        recyclerView.layoutManager = LinearLayoutManager(this)
        aboutFAB = findViewById(R.id.fab)
        carsAdapter = CarsAdapter(carsList)
        recyclerView.adapter = carsAdapter
        showRecyclerList()

        aboutFAB.setOnClickListener{
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

    }

    private fun getListCars(): ArrayList<Cars> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataYear = resources.getStringArray(R.array.data_year)
        val listCar = ArrayList<Cars>()
        for (i in dataName.indices){
            val car = Cars(dataPhoto.getResourceId(i, -1),dataName[i],dataYear[i],dataDescription[i])
            listCar.add(car)
        }
        return listCar
    }
    private fun showRecyclerList() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val carAdapter = CarsAdapter(carsList)
        recyclerView.adapter = carAdapter
    }
}
