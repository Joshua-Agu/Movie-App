package com.example.jhoehub.activities

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.jhoehub.R
import com.example.jhoehub.VpDAta
import com.example.jhoehub.adapter.MovieCategoriesAdapter
import com.example.jhoehub.adapter.TrendingMoviesAdapter
import com.example.jhoehub.adapter.UpcomingMoviesAdapter
import com.example.jhoehub.adapter.VpAdapter


class MainActivity : AppCompatActivity() {
    private lateinit var adapterTrending: TrendingMoviesAdapter
    private lateinit var adapterUpcoming: UpcomingMoviesAdapter
    private lateinit var adapterCategory: MovieCategoriesAdapter
    private lateinit var RecyclerViewTrending: RecyclerView
    private lateinit var RecyclerViewUpcoming: RecyclerView
    private lateinit var RecyclerViewCategory: RecyclerView
    private lateinit var viewPager2: ViewPager2
    private val slideHandler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initView()
        banners()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }

    private fun banners() {
        val vpDataList = mutableListOf<VpDAta>()
        vpDataList.add(VpDAta(drawableResId = R.drawable.vp1a))
        vpDataList.add(VpDAta(drawableResId = R.drawable.vp2a))
        vpDataList.add(VpDAta(drawableResId = R.drawable.vp3))
        vpDataList.add(VpDAta(drawableResId = R.drawable.vp4))
        vpDataList.add(VpDAta(drawableResId = R.drawable.vp5))
        vpDataList.add(VpDAta(drawableResId = R.drawable.vp6))
        vpDataList.add(VpDAta(drawableResId = R.drawable.vp7))
        vpDataList.add(VpDAta(drawableResId = R.drawable.vp8))
        vpDataList.add(VpDAta(drawableResId = R.drawable.vp9))

        viewPager2.setAdapter(VpAdapter(vpDataList, viewPager2))
        viewPager2.clipToPadding = false
        viewPager2.offscreenPageLimit = 4
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_ALWAYS

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - kotlin.math.abs(position)
            page.scaleX = 0.85f + r * 0.15f
        }
        viewPager2.setPageTransformer(compositePageTransformer)
        viewPager2.currentItem = 1
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                slideHandler.removeCallbacks(sliderRunnable)
            }
        })
    }

    private val sliderRunnable = Runnable {
        viewPager2.currentItem += 1
    }

    override fun onPause() {
        super.onPause()
        slideHandler.removeCallbacks(sliderRunnable)
    }

    override fun onResume() {
        super.onResume()
        slideHandler.postDelayed(sliderRunnable, 2500)
    }

    private fun initView() {
        viewPager2 = findViewById(R.id.viewpager2)
    }
}