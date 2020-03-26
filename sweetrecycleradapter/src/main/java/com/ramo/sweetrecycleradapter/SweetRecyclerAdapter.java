package com.ramo.sweetrecycleradapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SweetRecyclerAdapter<T> extends RecyclerView.Adapter<SweetRecyclerAdapter<T>.ViewHolder> {

    private Context context;
    private int resourceId;
    private List<T> list;
    private ISetItemView<T> iSetItemView;
    private IOnRecyclerItemClickListener<T> iOnRecyclerItemClickListener;

    public SweetRecyclerAdapter(Context context, int resourceId, List<T> list) {
        this.context = context;
        this.resourceId = resourceId;
        this.list = list;
    }

    public void setItemView(ISetItemView<T> iSetItemView) {
        this.iSetItemView = iSetItemView;
    }

    public void setOnRecyclerItemClickListener(IOnRecyclerItemClickListener<T> iOnRecyclerItemClickListener) {
        this.iOnRecyclerItemClickListener = iOnRecyclerItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(resourceId,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final T item = list.get(position);


        iSetItemView.setItemView(holder.view, item);

        if (iOnRecyclerItemClickListener != null)
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    iOnRecyclerItemClickListener.onRecyclerItemListener(holder.view, item);
                }
            });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }

    }
}
