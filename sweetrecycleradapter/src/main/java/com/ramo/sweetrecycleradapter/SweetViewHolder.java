package com.ramo.sweetrecycleradapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SweetViewHolder<T> extends RecyclerView.ViewHolder {

    private ItemHolder<T> itemHolder;

    public SweetViewHolder(@NonNull Context context, @NonNull ViewGroup parent, final ItemHolder itemHolder) {
        super(LayoutInflater.from(context).inflate(itemHolder.getResourceId(), parent, false));
        this.itemHolder = itemHolder;
    }

    public void bind(final T item) {
        itemHolder.getiSetItemView().setItemView(this.itemView, item);

        if (itemHolder.getOnRecyclerItemClickListener() != null)
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemHolder.getOnRecyclerItemClickListener().onRecyclerItemListener(view, item);
                }
            });
    }
}
