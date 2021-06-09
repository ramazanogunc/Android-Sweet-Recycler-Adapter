package com.ramo.sweetrecycleradapter

data class ItemHolder<T>(
        val resourceId: Int,
        val viewType: Int,
        val bindRecyclerItem: BindRecyclerItem<T>,
        val onRecyclerItemClickListener: OnRecyclerItemClickListener<T>
)