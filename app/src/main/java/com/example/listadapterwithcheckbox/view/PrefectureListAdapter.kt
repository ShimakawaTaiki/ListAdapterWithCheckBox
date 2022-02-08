package com.example.listadapterwithcheckbox.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listadapterwithcheckbox.databinding.PrefectureListItemBinding
import com.example.listadapterwithcheckbox.model.data.Prefecture
import com.example.listadapterwithcheckbox.viewmodel.MainViewModel

class PrefectureListAdapter(private val viewModel: MainViewModel, private val lifecycleOwner: LifecycleOwner): ListAdapter<Prefecture, PrefectureListAdapter.PrefectureViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrefectureViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PrefectureListItemBinding.inflate(layoutInflater, parent, false)
        return PrefectureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PrefectureViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current, viewModel, lifecycleOwner)
    }

    class PrefectureViewHolder(val binding: PrefectureListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(prefecture: Prefecture, viewModel: MainViewModel, lifecycleOwner: LifecycleOwner) {
            binding.let {
                it.prefecture = prefecture
                it.viewmodel = viewModel
                it.lifecycleOwner = lifecycleOwner

                it.executePendingBindings()
            }
        }
    }

    private object DiffCallback: DiffUtil.ItemCallback<Prefecture>() {
        override fun areContentsTheSame(oldItem: Prefecture, newItem: Prefecture): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: Prefecture, newItem: Prefecture): Boolean {
            return oldItem.name == newItem.name
        }
    }
}