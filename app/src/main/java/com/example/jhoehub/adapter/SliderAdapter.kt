package com.example.jhoehub.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jhoehub.R
import com.example.jhoehub.RvData
import com.squareup.picasso.Picasso

class SliderAdapter(private val sliderItems: List<RvData>) : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.movie_slider_container, parent, false)
        return SliderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return sliderItems.size
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        val sliderItem = sliderItems[position]
        Picasso.get().load(sliderItem.movieImage).into(holder.movieImage)

        holder.movieName.text = sliderItem.movieName
        holder.movieGenre.text = sliderItem.movieGenre
    }

    class SliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImage: ImageView = itemView.findViewById(R.id.movieImage)
        val movieName: TextView = itemView.findViewById(R.id.movieName)
        val movieGenre: TextView = itemView.findViewById(R.id.movieGenre)
    }
}