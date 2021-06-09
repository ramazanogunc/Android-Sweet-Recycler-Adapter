package com.ramo.test

import com.ramo.sweetrecycleradapter.ViewTypeListener

data class ExampleModel(val viewType: Int, val text: String) : ViewTypeListener {
    override fun getRecyclerViewType(): Int = viewType
}