package com.ramo.sweetrecycleradapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class SweetViewHolder<T>(
        parent: ViewGroup,
        private val itemHolder: ItemHolder<T>
) : ViewHolder(LayoutInflater.from(parent.context).inflate(itemHolder.layoutId, parent, false)) {
    fun bind(item: T) = itemHolder.bindRecyclerItem(itemView, item)
}
