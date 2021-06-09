package com.ramo.sweetrecycleradapter

import android.view.View

interface OnRecyclerItemClickListener<T> {
    fun onRecyclerItemListener(v: View, item: T)
}