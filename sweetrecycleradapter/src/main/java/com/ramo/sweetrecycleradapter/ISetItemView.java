package com.ramo.sweetrecycleradapter;

import android.view.View;

public interface ISetItemView<T>{
    void setItemView(View v, T item);
}