package com.ramo.test

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        sweetRecyclerAdapter.addHolder(R.layout.item1) { view, item ->
            val tw1 = view.findViewById<TextView>(R.id.tw1)
            tw1.text = item.text
        }
        sweetRecyclerAdapter.addHolder(R.layout.item2) { view, item ->
            val tw1 = view.findViewById<TextView>(R.id.l2tw1)
            tw1.text = item.text
        }

        sweetRecyclerAdapter.setOnItemClickListener { v, item ->
            Toast.makeText(this, "denemee", Toast.LENGTH_SHORT).show()
        }

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
