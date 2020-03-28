package com.ramo.sweetrecycleradapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SweetViewHolder<T> extends RecyclerView.ViewHolder {

        private int resourceId;
        private ISetItemView<T> iSetItemView;

        public SweetViewHolder( @NonNull Context context, @NonNull ViewGroup parent, int resourceId, ISetItemView<T> iSetItemView ) {
            super(LayoutInflater.from(context).inflate(resourceId, parent, false));
            this.resourceId = resourceId;
            this.iSetItemView = iSetItemView;
        }

        public void bind(T item) {
            iSetItemView.setItemView(this.itemView,item);
        }

}
