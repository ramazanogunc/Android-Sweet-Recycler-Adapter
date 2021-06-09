package com.ramo.sweetrecycleradapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class SweetViewHolder<T>(
        parent: ViewGroup,
        itemHolder: ItemHolder<T>
) : ViewHolder(LayoutInflater.from(parent.context).inflate(itemHolder.resourceId, parent, false)) {
    private val itemHolder: ItemHolder<T> = itemHolder
    fun bind(item: T) {
        itemHolder.bindRecyclerItem.bindItemView(itemView, item)
        if (itemHolder.onRecyclerItemClickListener != null) itemView.setOnClickListener { view -> itemHolder.onRecyclerItemClickListener.onRecyclerItemListener(view, item) }
    }
}
