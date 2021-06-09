package com.ramo.sweetrecycleradapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SweetRecyclerAdapter<T : ViewTypeListener>(
        private val list: List<T>,
) : RecyclerView.Adapter<SweetViewHolder<T>>() {

    private val itemHolderList = mutableListOf<ItemHolder<T>>()
    private var onItemClick: ((View, T) -> Unit)? = null

    fun addHolder(layoutId: Int, bindRecyclerItem: (v: View, item: T) -> Unit) =
        itemHolderList.add(ItemHolder<T>(layoutId, bindRecyclerItem))


    fun setOnItemClickListener(onItemClick: (v: View, item: T) -> Unit) {
        this.onItemClick = onItemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SweetViewHolder<T> {
        for (i in itemHolderList.indices) {
            val item: ItemHolder<T> = itemHolderList[i]
            if (viewType == item.layoutId) return SweetViewHolder(parent, item)
        }
        throw HolderNotFoundException()
    }

    override fun onBindViewHolder(holder: SweetViewHolder<T>, position: Int) {
        val item = list[position]
        holder.bind(item)
        if (onItemClick != null)
            holder.itemView.setOnClickListener { view ->
                onItemClick?.invoke(view, item)
            }
    }

    override fun getItemViewType(position: Int) = list[position].getRecyclerItemLayoutId()
    override fun getItemCount() = list.size
}