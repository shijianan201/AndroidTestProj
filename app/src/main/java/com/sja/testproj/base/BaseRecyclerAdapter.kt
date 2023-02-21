package com.sja.testproj.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseRecyclerAdapter<T, VH : BaseRecyclerAdapter.BaseRecyclerViewHolder<in T>>(private val dataList: List<T>) :
    RecyclerView.Adapter<VH>() {

    override fun onBindViewHolder(holder: VH, position: Int) {
        val data = dataList[position]
        holder.bindData(position, data)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    abstract class BaseRecyclerViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

        abstract fun bindData(position: Int, data: T)

    }

    abstract class BaseViewBindingViewHolder<T,VB:ViewBinding>(val viewBinding:VB): BaseRecyclerViewHolder<T>(viewBinding.root)

}

