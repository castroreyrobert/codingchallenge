package com.example.codingchallenge.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.codingchallenge.data.domain.model.levels.Level
import com.example.codingchallenge.databinding.ItemLevelBinding

class LevelAdapter(private val levels: List<Level>): RecyclerView.Adapter<LevelAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemLevelBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(level: Level) {
            binding.textViewLevelTitle.text = level.title
            binding.textViewLevelPosition.text = "Level ${level.level}"
            binding.textViewLevelDescription.text = level.description
            binding.recyclerViewActivities.apply {
                layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                adapter = ActivityAdapter(level.activities)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLevelBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = levels.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(level = levels[position])
    }
}