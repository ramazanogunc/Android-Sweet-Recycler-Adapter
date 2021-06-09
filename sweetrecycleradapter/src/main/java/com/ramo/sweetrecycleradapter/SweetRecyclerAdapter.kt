package com.ramo.sweetrecycleradapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class SweetRecyclerAdapter<T : ViewTypeListener>(
        private val list: List<T>
) : RecyclerView.Adapter<SweetViewHolder<T>>() {

    private val itemHolderList = mutableListOf<ItemHolder<T>>()

    fun addHolder(resourceId: Int, viewType: Int, bindRecyclerItem: BindRecyclerItem<T>, onRecyclerItemClickListener: OnRecyclerItemClickListener<T>) {
        itemHolderList.add(ItemHolder<T>(resourceId, viewType, bindRecyclerItem, onRecyclerItemClickListener))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SweetViewHolder<T> {
        for (i in itemHolderList.indices) {
            val item: ItemHolder<T> = itemHolderList[i]
            if (viewType == item.viewType) return SweetViewHolder(parent, item)
        }
        throw HolderNotFoundException()
    }

    override fun onBindViewHolder(holder: SweetViewHolder<T>, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].getRecyclerViewType()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}