package com.example.kipoapps.Home.pertemuan_10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kipoapps.databinding.ItemProductBinding

class ProductAdapter(private val listProduct: List<ProductModel>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = listProduct[position]
        holder.binding.apply {
            tvProductName.text = product.name
            tvProductPrice.text = product.price
            ivProduct.setImageResource(product.imageResId)
        }
    }

    override fun getItemCount(): Int = listProduct.size
}