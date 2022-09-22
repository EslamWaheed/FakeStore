package com.eslamwaheed.fakestore.base

import android.annotation.SuppressLint
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(private val list: ArrayList<T>?) :
    RecyclerView.Adapter<BaseAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return if (list?.isNotEmpty() == true) list.size else 0
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: ArrayList<T>?) {
        newList?.let {
            list?.addAll(it)
            notifyDataSetChanged()
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mBinding: ViewDataBinding? = DataBindingUtil.bind(itemView)
    }
}