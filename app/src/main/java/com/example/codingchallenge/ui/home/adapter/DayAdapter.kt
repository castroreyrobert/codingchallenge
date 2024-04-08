package com.example.codingchallenge.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.codingchallenge.R
import com.example.codingchallenge.data.domain.model.levels.Day
import com.example.codingchallenge.databinding.ItemDayBinding

class DayAdapter(
    days: List<Day>
): RecyclerView.Adapter<DayAdapter.ViewHolder>() {

    private val dayList = mutableListOf<Day>()

    init {
        dayList.clear()
        dayList.addAll(days)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemDayBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(day: Day, onItemClickListener: () -> Unit) {
            binding.imageViewDay.setOnClickListener { onItemClickListener.invoke() }
            binding.textViewDay.text = day.name
            binding.imageViewDay.setImageResource(if (day.isSelected) R.drawable.ic_day_selected else R.drawable.ic_day_unselected)
            binding.dividerSelected.isVisible = day.isSelected
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDayBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    private fun updateItem(position: Int) {
        dayList.forEachIndexed { index, _ ->
            dayList[index].isSelected = index == position
        }
        notifyDataSetChanged()
    }

    override fun getItemCount() = dayList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(dayList[position], onItemClickListener = { updateItem(position) })
    }



}