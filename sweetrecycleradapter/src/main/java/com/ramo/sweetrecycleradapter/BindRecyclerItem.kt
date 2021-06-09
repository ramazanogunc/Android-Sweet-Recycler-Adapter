package com.ramo.sweetrecycleradapter

import android.view.View

interface BindRecyclerItem<T> {
    fun bindItemView(v: View, item: T)
}