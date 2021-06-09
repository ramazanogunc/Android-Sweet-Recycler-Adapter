package com.ramo.sweetrecycleradapter;

public class ItemHolder<T> {
    private int resourceId;
    private int viewType;
    private ISetItemView<T> iSetItemView;
    private OnRecyclerItemClickListener<T> onRecyclerItemClickListener;

    public ItemHolder(int resourceId, int viewType, ISetItemView<T> iSetItemView, OnRecyclerItemClickListener<T> onRecyclerItemClickListener) {
        this.resourceId = resourceId;
        this.viewType = viewType;
        this.iSetItemView = iSetItemView;
        this.onRecyclerItemClickListener = onRecyclerItemClickListener;
    }

    public int getViewType() {
        return viewType;
    }

    public int getResourceId() {
        return resourceId;
    }

    public ISetItemView<T> getiSetItemView() {
        return iSetItemView;
    }

    public OnRecyclerItemClickListener<T> getOnRecyclerItemClickListener() {
        return onRecyclerItemClickListener;
    }
}
