package com.eslamwaheed.fakestore.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.eslamwaheed.fakestore.R
import com.eslamwaheed.fakestore.base.BaseAdapter
import com.eslamwaheed.fakestore.databinding.ItemProductBinding
import com.eslamwaheed.fakestore.models.entities.ProductsResponseItem

class ProductsAdapter(
    private val list: ArrayList<ProductsResponseItem?>?,
    private val clickAction: ((ProductsResponseItem?) -> (Unit))?
) :
    BaseAdapter<ProductsResponseItem?>(list) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = holder.mBinding
        if (binding is ItemProductBinding) {
            binding.data = list?.get(position)
            binding.clRootProduct.setOnClickListener {
                clickAction?.invoke(list?.get(position))
            }
        }
    }
}