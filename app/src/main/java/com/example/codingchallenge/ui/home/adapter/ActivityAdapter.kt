package com.example.codingchallenge.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.codingchallenge.R
import com.example.codingchallenge.domain.model.LevelActivity
import com.example.codingchallenge.databinding.ItemActivityBinding

class ActivityAdapter(private val activities: List<LevelActivity>): RecyclerView.Adapter<ActivityAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemActivityBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(levelActivity: LevelActivity) {
            binding.textViewActivityTitle.text = levelActivity.title

            Glide.with(binding.root.context)
                .load(levelActivity.icon.file.url)
                .error(R.drawable.image_lesson)
                .into(binding.imageViewActivity)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemActivityBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount() = activities.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(activities[position])
    }
}