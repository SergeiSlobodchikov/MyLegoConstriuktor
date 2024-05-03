package com.example.assembletheconstructoryourself

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.assembletheconstructoryourself.databinding.ItemDetailBinding

class LegoPartsAdapter : ListAdapter<LegoParts, LegoPartsViewHolder>(LegoPartsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LegoPartsViewHolder {
        val binding = ItemDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LegoPartsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LegoPartsViewHolder, position: Int) {
        val legoPart = getItem(position)
        holder.bind(legoPart)
    }
}

class LegoPartsViewHolder(private val binding: ItemDetailBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(legoPart: LegoParts) {
        binding.nameDatail.text = legoPart.name
        binding.amountOfDetail.setText(legoPart.quantity.toString())
    }
}

class LegoPartsDiffCallback : DiffUtil.ItemCallback<LegoParts>() {
    override fun areItemsTheSame(oldItem: LegoParts, newItem: LegoParts): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: LegoParts, newItem: LegoParts): Boolean {
        return oldItem == newItem
    }
}