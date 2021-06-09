package com.ramo.sweetrecycleradapter

import android.view.View

data class ItemHolder<T>(
        val layoutId: Int,
        val bindRecyclerItem: (v: View, item: T) -> Unit
)