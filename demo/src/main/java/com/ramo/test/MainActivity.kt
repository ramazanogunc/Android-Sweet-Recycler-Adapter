package com.ramo.test

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ramo.sweetrecycleradapter.BindRecyclerItem
import com.ramo.sweetrecycleradapter.OnRecyclerItemClickListener
import com.ramo.sweetrecycleradapter.SweetRecyclerAdapter
import java.util.*

class MainActivity : AppCompatActivity() {
    var fakeList = mutableListOf<ExampleModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fakeData()
        val recyclerView = findViewById<RecyclerView>(R.id.rw)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val sweetRecyclerAdapter = SweetRecyclerAdapter(fakeList)
        sweetRecyclerAdapter.addHolder(R.layout.item1, 0, object : BindRecyclerItem<ExampleModel> {
            override fun bindItemView(v: View, item: ExampleModel) {
                val tw1 = v.findViewById<TextView>(R.id.tw1)
                tw1.text = item.text
            }
        }, object : OnRecyclerItemClickListener<ExampleModel> {
            override fun onRecyclerItemListener(v: View, item: ExampleModel) {
                Toast.makeText(this@MainActivity, "Layout0 on Clicked", Toast.LENGTH_SHORT).show()
            }
        })
        sweetRecyclerAdapter.addHolder(R.layout.item2, 1, object : BindRecyclerItem<ExampleModel> {
            override fun bindItemView(v: View, item: ExampleModel) {
                val tw1 = v.findViewById<TextView>(R.id.l2tw1)
                tw1.text = item.text
            }
        }, object : OnRecyclerItemClickListener<ExampleModel> {
            override fun onRecyclerItemListener(v: View, item: ExampleModel) {
                Toast.makeText(this@MainActivity, "Layout1 on Clicked", Toast.LENGTH_SHORT).show()
            }
        })
        recyclerView.adapter = sweetRecyclerAdapter
    }

    private fun fakeData() {
        fakeList.add(ExampleModel(0, "RamoL0"))
        fakeList.add(ExampleModel(1, "RamoL1"))
        fakeList.add(ExampleModel(0, "RamoL0"))
        fakeList.add(ExampleModel(0, "RamoL0"))
        fakeList.add(ExampleModel(1, "RamoL1"))
    }
}
