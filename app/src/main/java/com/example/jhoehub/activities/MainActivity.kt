package com.example.jhoehub.activities

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.jhoehub.R

class MainActivity : AppCompatActivity() {

    private lateinit var search: EditText
    private lateinit var viewPager: ViewPager2
    private lateinit var trending: TextView
    private lateinit var trendingRecycle: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var category: TextView
    private lateinit var viewRecycle2: RecyclerView
    private lateinit var progressBar2: ProgressBar
    private lateinit var comingSoon: TextView
    private lateinit var view3: RecyclerView
    private lateinit var progressBar3: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        search = findViewById(R.id.search)
        viewPager = findViewById(R.id.viewpager)
        trending = findViewById(R.id.Trending)
        trendingRecycle = findViewById(R.id.trendingRecycle)
        progressBar = findViewById(R.id.progressBar)
        category = findViewById(R.id.Category)
        viewRecycle2 = findViewById(R.id.VIEWrecycle2)
        progressBar2 = findViewById(R.id.progressBar2)
        comingSoon = findViewById(R.id.ComingSoon)
        view3 = findViewById(R.id.VIEW3)
        progressBar3 = findViewById(R.id.progressBar3)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fun performSearch(query: String) {
            // 1. Make an API call to fetch search results using Retrofit
            // 2. Update the UI with the search results (e.g., update a RecyclerView adapter)
            // 3. Consider showing a ProgressBar while searching and handling potential errors
        }
        search.setOnClickListener {
            val query = search.text.toString()
            if (query.isNotBlank()) {
                performSearch(query)
            }
        }


    }
}