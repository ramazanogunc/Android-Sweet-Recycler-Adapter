package com.ramo.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.ramo.sweetrecycleradapter.IOnRecyclerItemClickListener;
import com.ramo.sweetrecycleradapter.ISetItemView;
import com.ramo.sweetrecycleradapter.SweetRecyclerAdapter;
import com.ramo.sweetrecycleradapter.SweetViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<User> user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fakeData();


        RecyclerView recyclerView = findViewById(R.id.rw);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SweetRecyclerAdapter<User> sweetRecyclerAdapter = new SweetRecyclerAdapter<>(this,user);

        sweetRecyclerAdapter.addHolder(R.layout.item1, 0, new ISetItemView<User>() {
            @Override
            public void setItemView(View v, User item) {
                TextView tw1 = v.findViewById(R.id.txtTv1);
                TextView tw2 = v.findViewById(R.id.txtT2);

                tw1.setText(item.getName());
                tw1.setText(item.getSurname());
            }
        }, new IOnRecyclerItemClickListener<User>() {
            @Override
            public void onRecyclerItemListener(View v, User item) {
            }
        });


        sweetRecyclerAdapter.addHolder(R.layout.item2, 1, new ISetItemView<User>() {
            @Override
            public void setItemView(View v, User item) {
                CheckBox cb = v.findViewById(R.id.chkRemember);

                cb.setChecked(true);
            }
        }, new IOnRecyclerItemClickListener<User>() {
            @Override
            public void onRecyclerItemListener(View v, User item) {
            }
        });

        recyclerView.setAdapter(sweetRecyclerAdapter);

    }


    private void fakeData()
    {
        user =  new ArrayList<>();
        User user2 = new User(0,"sdgfsdg", "sezfdghfghgin", true);
        User user3 = new User(1,"burak", "sezgin", true);
        User user4 = new User(0,"Ramo", "sezgdsfsdin", true);
        User user5 = new User(1,"buradsfsdfk", "sezgin", false);

        user.add(user2);
        user.add(user3);
        user.add(user4);
        user.add(user5);
    }
}
