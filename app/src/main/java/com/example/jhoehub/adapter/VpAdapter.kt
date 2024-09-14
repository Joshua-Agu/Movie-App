package com.example.jhoehub.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.jhoehub.R
import com.example.jhoehub.VpDAta

class VpAdapter(private var sliderItems: MutableList<VpDAta> = mutableListOf(), private val viewPager2: ViewPager2) : RecyclerView.Adapter<VpAdapter.SliderVpViewHolder>() {

    interface ItemUpdateListener {
        fun onItemsUpdated()
    }

    class SliderVpViewHolder(itemView: View, private val sliderItems: MutableList<VpDAta>, private val listener: ItemUpdateListener) : RecyclerView.ViewHolder(itemView) {    private var vpImage : ImageView = itemView.findViewById(R.id.vpImage)

        @RequiresApi(Build.VERSION_CODES.S)
        fun setImage(sliderItem: VpDAta) {
            val requestOptions = RequestOptions().transform(CenterCrop(), RoundedCorners(68))

            when {
                sliderItem.imageUrl != null -> {
                    Glide.with(itemView)
                        .load(sliderItem.imageUrl)
                        .apply(requestOptions)
                        .placeholder(R.drawable.loading) // Placeholder for image URLs
                        .error(R.drawable.error)       // Error for image URLs
                        .into(vpImage)
                }
                sliderItem.drawableResId != null -> {
                    Glide.with(itemView)
                        .load(sliderItem.drawableResId)
                        .apply(requestOptions)
                        .placeholder(R.drawable.loading) // Placeholder for drawables
                        .error(R.drawable.error)             // Error for drawables
                        .into(vpImage)
                }
            }
        }
        val runnable = Runnable {
                sliderItems.addAll(sliderItems)
                listener.onItemsUpdated()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderVpViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.viewpager_item_layout, parent, false)
        return SliderVpViewHolder(view, sliderItems, object : ItemUpdateListener
        {
            override fun onItemsUpdated() {
                notifyItemInserted(sliderItems.size - 1)
            }
        })
    }


    override fun getItemCount(): Int {
        return sliderItems.size
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onBindViewHolder(holder: SliderVpViewHolder, position: Int) {
        holder.setImage(sliderItems[position])
        if (position == sliderItems.size - 2) {
            viewPager2.post(holder.runnable)
        }
    }


}

