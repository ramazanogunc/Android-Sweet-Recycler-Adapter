package com.ramo.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ramo.sweetrecycleradapter.ISetItemView;
import com.ramo.sweetrecycleradapter.OnRecyclerItemClickListener;
import com.ramo.sweetrecycleradapter.SweetRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ExampleModel> fakeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fakeData();


        RecyclerView recyclerView = findViewById(R.id.rw);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SweetRecyclerAdapter<ExampleModel> sweetRecyclerAdapter = new SweetRecyclerAdapter<>(this,fakeList);

        sweetRecyclerAdapter.addHolder(R.layout.item1, 0, new ISetItemView<ExampleModel>() {
            @Override
            public void setItemView(View v, ExampleModel item) {
                TextView tw1 = v.findViewById(R.id.tw1);
                tw1.setText(item.getText());
            }
        }, new OnRecyclerItemClickListener<ExampleModel>() {
            @Override
            public void onRecyclerItemListener(View v, ExampleModel item) {
                Toast.makeText(MainActivity.this, "Layout0 on Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        sweetRecyclerAdapter.addHolder(R.layout.item2, 1, new ISetItemView<ExampleModel>() {
            @Override
            public void setItemView(View v, ExampleModel item) {
                TextView tw1 = v.findViewById(R.id.l2tw1);
                tw1.setText(item.getText());
            }
        }, new OnRecyclerItemClickListener<ExampleModel>() {
            @Override
            public void onRecyclerItemListener(View v, ExampleModel item) {
                Toast.makeText(MainActivity.this, "Layout1 on Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(sweetRecyclerAdapter);

    }


    private void fakeData()
    {
        fakeList =  new ArrayList<>();
        fakeList.add(new ExampleModel(0, "RamoL0"));
        fakeList.add(new ExampleModel(1, "RamoL1"));
        fakeList.add(new ExampleModel(0, "RamoL0"));
        fakeList.add(new ExampleModel(0, "RamoL0"));
        fakeList.add(new ExampleModel(1, "RamoL1"));
    }
}
