package com.example.mvvmexample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexample.Brands
import com.example.mvvmexample.databinding.ItemBrandBinding

//CADA ITEMS DE LA LISTA
class BrandsAdapter(
    private val characterResponse: List<Brands>
) :
    RecyclerView.Adapter<BrandsAdapter.ViewHolder>() {
    class ViewHolder(
        private val binding: ItemBrandBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun binData(item: Brands) {
            binding.brand = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.character_list, parent, false)
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBrandBinding.inflate(inflater)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return characterResponse.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binData(characterResponse[position])
    }

}