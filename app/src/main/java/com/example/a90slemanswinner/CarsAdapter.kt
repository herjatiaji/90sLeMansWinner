package com.example.a90slemanswinner

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView.RecyclerListener
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class CarsAdapter (private val carsList: ArrayList<Cars>) : RecyclerView.Adapter<CarsAdapter.CarsViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CarsViewHolder(view)

    }

    override fun getItemCount(): Int {
        return carsList.size
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        val (image, name,year)= carsList[position]
        holder.imgView.setImageResource(image)
        holder.cars.text = name
        holder.year.text = year
        holder.itemView.setOnClickListener{
            val intentDetail = Intent(holder.itemView.context, CarsPage::class.java)
            intentDetail.putExtra("key_car", carsList[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }



    }
    class CarsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgView: ImageView = itemView.findViewById(R.id.imgviewPic)
        val cars : TextView = itemView.findViewById(R.id.tv_cars)
        val year : TextView = itemView.findViewById(R.id.tv_year)
    }
}