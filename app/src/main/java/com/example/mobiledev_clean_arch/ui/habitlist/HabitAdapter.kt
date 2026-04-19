package com.example.mobiledev_clean_arch.ui.habitlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Habit
import com.example.mobiledev_clean_arch.databinding.ItemHabitBinding

class HabitAdapter(
    private val onCheckChanged: (Long) -> Unit,
    private val onItemClick: (Long) -> Unit
) : ListAdapter<Habit, HabitAdapter.HabitViewHolder>(DIFF_CALLBACK) {

    private val completedToday = mutableSetOf<Long>()

    fun updateCompletedToday(ids: Set<Long>) {
        completedToday.clear()
        completedToday.addAll(ids)
        notifyDataSetChanged()
    }

    inner class HabitViewHolder(private val binding: ItemHabitBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(habit: Habit) {
            binding.tvTitle.text = habit.title
            binding.tvDescription.text = habit.description
            binding.colorIndicator.setBackgroundColor(habit.color)
            binding.cbCompleted.setOnCheckedChangeListener(null)
            binding.cbCompleted.isChecked = completedToday.contains(habit.id)
            binding.cbCompleted.setOnCheckedChangeListener { _, _ -> onCheckChanged(habit.id) }
            binding.root.setOnClickListener { onItemClick(habit.id) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val binding = ItemHabitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HabitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) = holder.bind(getItem(position))

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Habit>() {
            override fun areItemsTheSame(oldItem: Habit, newItem: Habit) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Habit, newItem: Habit) = oldItem == newItem
        }
    }
}
