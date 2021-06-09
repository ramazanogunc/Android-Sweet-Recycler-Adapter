package com.ramo.test

import com.ramo.sweetrecycleradapter.ViewTypeListener

data class ExampleModel(val viewType: Int, val text: String) : ViewTypeListener {
    override fun getRecyclerItemLayoutId(): Int {
        return if (viewType == 0) R.layout.item1
        else R.layout.item2
    }
}