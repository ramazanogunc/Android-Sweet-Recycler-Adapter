package com.ramo.sweetrecycleradapter;

import android.view.View;

public interface IOnRecyclerItemClickListener<T>{
    void onRecyclerItemListener(View v, T item);
}