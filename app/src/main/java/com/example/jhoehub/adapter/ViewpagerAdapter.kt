package com.example.jhoehub.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jhoehub.R
import com.squareup.picasso.Picasso

class ViewPagerAdapter(private val featuredMovies: List<viewPager>) :
    RecyclerView.Adapter<ViewPagerAdapter.MovieViewHolder>() {

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.movieImage)
        val titleTextView: TextView =itemView.findViewById(R.id.movieName)
        val genreTextView: TextView = itemView.findViewById(R.id.movieGenre)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewpager, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = featuredMovies[position]

        Picasso.get().load(movie.imageUrl)
            .into(holder.imageView)

        holder.titleTextView.text = movie.title
        holder.genreTextView.text = movie.genre
    }

    override fun getItemCount(): Int {
        return featuredMovies.size
    }
}