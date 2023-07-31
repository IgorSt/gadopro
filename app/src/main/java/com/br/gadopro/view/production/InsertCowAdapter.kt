package com.br.gadopro.view.production

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.br.gadopro.data.model.Cow
import com.br.gadopro.databinding.ItemCowInfosBinding

class InsertCowAdapter : ListAdapter<Cow, InsertCowAdapter.ProductionVH>(DiffCallback) {

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Cow>() {
            override fun areItemsTheSame(oldItem: Cow, newItem: Cow) = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Cow, newItem: Cow) = oldItem == newItem

        }
    }

    class ProductionVH(
        private val binding: ItemCowInfosBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun setup (cow: Cow) {
            binding.data = cow
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductionVH {
        return ProductionVH(
            ItemCowInfosBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductionVH, position: Int) {
        holder.setup(getItem(position))
    }
}