package com.ramo.sweetrecycleradapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SweetRecyclerAdapter<T extends ViewTypeListener> extends RecyclerView.Adapter<SweetViewHolder<T>> {

    private Context context;
    private List<T> list;
    private List<ItemHolder> itemHolderList = new ArrayList<>();

    public SweetRecyclerAdapter(Context context, List<T> list) {
        this.context = context;
        this.list = list;
    }

    public void addHolder(int resourceId, int viewType, ISetItemView<T> iSetItemView,OnRecyclerItemClickListener<T> onRecyclerItemClickListener) {
        itemHolderList.add(new ItemHolder(resourceId, viewType, iSetItemView,onRecyclerItemClickListener));
    }

    @NonNull
    @Override
    public SweetViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        for (int i = 0; i < itemHolderList.size(); i++) {
            ItemHolder<T> item = itemHolderList.get(i);
            if (viewType == item.getViewType())
                return new SweetViewHolder<>(context,parent,item);
        }
        return null;

    }

    @Override
    public void onBindViewHolder(@NonNull SweetViewHolder<T> holder, int position) {
        T item = list.get(position);
        holder.bind(item);
    }


    @Override
    public int getItemViewType(int position) {
        return list.get(position).getRecyclerViewType();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
